package com.wxj.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wxj.common.CookieUtil;
import com.wxj.common.SHAEncypt;
import com.wxj.common.TokenUtil;
import com.wxj.dao.JedisClient;
import com.wxj.dao.ResignOrLoginDao;
import com.wxj.entity.User;
import com.wxj.service.ResignOrLoginService;
@Service
public class ResignOrLoginServiceImpl implements ResignOrLoginService{
	@Autowired
	ResignOrLoginDao dao;
	@Autowired
	JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	/*
	 * 查询数据库中Id
	 */
	public String getMaxId(){
		String id = dao.selectMaxId();

		return id;
	}

	/*
	 * 
	 */
	public User setId(User user){
		String id ="";
		String maxId = getMaxId();
		if(null==maxId ){
			System.out.println("系统中还没有用户，即将初始化用户id为1");
			id = "1";
		}else{
			id = (Long.parseLong(maxId)+1)+"";//id规则为递增，递增梯度为1
		}
		
		
		user.setId(id);
		
		return user;	
	}
	
	/*
	 * 注册 id的赋值最好是在后台执行，在前台加载数据是去数据库查询最大的id是，有同时又两个用户同时注册的情况，那么两个用户传过来的id很可能就是
	 * 冲突的，提交后在后台进行id赋值比较好
	 */
	@Override
	public String resign(User user) {
		
		String res ="";
		String ps =user.getPassword();
		String password = SHAEncypt.SHA256(ps);
		user.setPassword("");
		user.setPassword(password);
		
		
		//查询数据库Id,给用户添加id
		User newUser = setId(user);
		//给密码加密，避免出现明文密码
		
		//newUser.setPassword(password);
		
		
		int result = dao.addUser(newUser);
		if (result==1){
			res = "SUCCESS";
		}else{
			res = "FAIL";
		}
		return res;
	}
   /***************************************登录部分*********************************************/ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/*
	 * 登录
	 */
	@Override
	public String login(String loginString,String password,HttpServletRequest request,HttpServletResponse response) {
		String res="";
		Map map = new HashMap();
		//处理密码加密问题
		String newPassword = SHAEncypt.SHA256(password);
		
		//把参数添加到map中
		map.put("loginString", loginString);
		map.put("password", newPassword);
	
		int result=dao.loginUser(map);
		//如果用户登录成功，把token保存在cookie和redis中各一份
		if(result != 0){
			//生成token
			String token = TokenUtil.getToken();
			//把token保存在redis中
			jedisClient.set(REDIS_USER_SESSION_KEY, token);
			//设置过期时间
			jedisClient.expire(REDIS_USER_SESSION_KEY, SSO_SESSION_EXPIRE);
			
			//使用cookie
			CookieUtil.setCookie(request, response, "USER_TOKEN", token);
		
			res="SUCCESS";
			 
			 
			 
			 
		}else{
			 res="FAIL";
		}
		return res;
	}
    
	
	public String getUserByToken(String token,String callBack){
		String json = jedisClient.get(REDIS_USER_SESSION_KEY);
		
		//判断是否为空
		if(StringUtils.isBlank(json)){
			return "登录已经过期请重新登录";
		}
		
		//更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY, SSO_SESSION_EXPIRE);
		//返回用户信息
		return "登录成功";
	}
	
	
	
	
	
	
	
	
}
