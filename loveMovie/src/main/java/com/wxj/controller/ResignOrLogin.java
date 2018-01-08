package com.wxj.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxj.entity.User;
import com.wxj.service.ResignOrLoginService;


@Controller
@RequestMapping("/resignOrLogin")
public class ResignOrLogin {
	
	Logger logger = LoggerFactory.getLogger(ResignOrLogin.class);
	
    @Autowired
	 ResignOrLoginService service;
    
    /*
     * 从其他页面请求注册或者登陆
     */
    @RequestMapping("/toResign")
    public String toResign(){
    	logger.info("进入注册页面");
    	return "resignOrLogin/resign";
    }
    
    @RequestMapping("/toLogin")
    public String toLogin(){
    	logger.info("进入登录页面");
    	return "resignOrLogin/login";
    }
    
    
    
    /*注册压面操作*/
    @RequestMapping("/resign.do")
    public String resign(User user){
        logger.info("用户进行注册环节");
    	String result=service.resign(user);
    	if(result.equals("SUCCESS")){
    		System.out.println("将要跳转登录页面");
    		return "resignOrLogin/login";
    	}else{
    		return "resignOrLogin/login";
    	}
    	
    }
    
    
    /*登陆方式
    1、用户名登陆方式
    2、手机登陆方式
    3、邮箱登陆方式
    */
    @SuppressWarnings("unchecked")
	@RequestMapping("/login.do") 
   	public String login(String loginString,String password){
       
    	
    	Map map = new HashMap();
       	String res = null; 
       	String returnRes=null;
       	 //密码加盐
       	 
         map.put("loginString", loginString);
         map.put("password", password);
        
         res = service.login(map);
    	 
         
         
         
         if(res.equals("SUCCESS")){
        	 returnRes= "/index";
         }else{
        	 returnRes="用户名或密码错误";
         }
         
         
    	
    	System.out.println("进入了controller"); 
       	  return returnRes;
          }
      
       
       
       
}
