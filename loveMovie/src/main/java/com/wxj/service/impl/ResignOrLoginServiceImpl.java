package com.wxj.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxj.common.SHAEncypt;
import com.wxj.dao.ResignOrLoginDao;
import com.wxj.entity.User;
import com.wxj.service.ResignOrLoginService;
@Service
public class ResignOrLoginServiceImpl implements ResignOrLoginService{
	@Autowired
	ResignOrLoginDao dao;
	
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
		
		//查询数据库Id,给用户添加id
		User newUser = setId(user);
		//给密码加密，避免出现明文密码
		String password = SHAEncypt.SHA256(newUser.getPassword());
		newUser.setPassword(password);
		
		
		int result = dao.addUser(newUser);
		if (result==1){
			res = "SUCCESS";
		}else{
			res = "FAIL";
		}
		return res;
	}
   /***************************************登录部分*********************************************/ 
	/*
	 * 登录
	 */
	@Override
	public String login(Map map) {
		String res="";
		
		//处理密码加密问题
		String password = (String) map.get("password");
		SHAEncypt.SHA256(password);
		map.put("password", password);
		
		int result=dao.loginUser(map);
		
		if(result == 1){
			 res="SUCCESS";
		}else{
			 res="FAIL";
		}
		return res;
	}

}
