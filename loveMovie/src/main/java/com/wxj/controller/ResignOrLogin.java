package com.wxj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.json.MappingJacksonValue;
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
   	public String login(String loginString,String password,HttpServletRequest request,HttpServletResponse response){
       
    	
    	Map map = new HashMap();
       	String res = null; 
       	String returnRes=null;

        res = service.login(loginString,password,request,response);
    	 
         
         
         
         if(res.equals("SUCCESS")){
        	 returnRes= "redirect:/index.jsp";
         }else{
        	 returnRes="error";
         }
         
         
    	
    	System.out.println("进入了controller"); 
       	  return returnRes;
          }
      
       
    
    /*
     * 获取token
     */
      @RequestMapping("/token")
      public Object getUserByToken(String token,String callback){
    	  String result="";
    	   result = service.getUserByToken(token);
    	  
    	  //判断是否为jsonP调用
    	   if(StringUtils.isBlank(callback)){
    		   return result;
    	   }else{
    		   MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
    		   mappingJacksonValue.setJsonpFunction(callback);
    		   return mappingJacksonValue;
    	   }
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }
      
       
}
