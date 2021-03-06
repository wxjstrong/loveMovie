package com.wxj.common;


import java.util.UUID;

import org.junit.Test;

public class TokenUtil {
  
	public static String getToken(){
		//token 生成规则  SHA-256加密（时间戳 +UUID+时间戳）
    	
		Long timestamp = System.currentTimeMillis();
		String uuid = UUID.randomUUID().toString();
		String token = SHAEncypt.SHA256(timestamp+uuid+timestamp);
		
		return token;
	}
}
