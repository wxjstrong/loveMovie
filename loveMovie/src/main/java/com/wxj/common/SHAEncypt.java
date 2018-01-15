package com.wxj.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHAEncypt {
       /*
        * sha加密
        */
	
	  //传入文本内容，返回SHA-256串
	   public static String SHA256(final String strText){
		   return SHA(strText,"SHA-256");
	   }
	   
	   //传入文本内容，返回SHA-256串
	   public static String SHA512(final String strText){
		   return SHA(strText,"SHA-512");
	   }
	   
	   
	   public static String SHA(final String strText,final String strType){
		   String strResult = null;
		   if(strText != null && strText.length()>0){
			   try{
				   //sha加密开始
				   //创建加密对象，并传入加密类型
				   MessageDigest messageDigest = MessageDigest.getInstance(strType);
				   //传入要加密的字符串
				   messageDigest.update(strText.getBytes());
				   
				   //得到byte类型结果
				   byte byteBuffer[] = messageDigest.digest();
				   //将byte装换成string
				   StringBuffer strHexString = new StringBuffer();
				   //遍历byte Buffer  
				   for(int i=0;i<byteBuffer.length;i++){
					   String hex = Integer.toHexString(0xff & byteBuffer[i]);
					   if(hex.length() == 1){
						   strHexString.append('0');
					   }
					   
					   strHexString.append(hex);
				   }
				   //得到返回结果
				   strResult = strHexString.toString();
				   
				   
				   
			   }catch(NoSuchAlgorithmException e){
				   e.printStackTrace();
			   }
		   }
		   
		   
		   return strResult;
	   }
	   
	   public static void main(String[] args) {
			/*System.out.println(System.currentTimeMillis() / 1000);
			String str = SHAEncypt.SHA256("1493975115V8iHDLMDfPQjRHABa2IWsumQftMf964tNW1sDUXpqvIeGUNaxtjqab570e0a:015a1d0fbef0:00cb3d1493975115");
			System.out.println(str.toUpperCase());*/
		   
		   
		   String str = SHAEncypt.SHA256("1");
			System.out.println(str);	
			String str1 = SHAEncypt.SHA256("1");
			System.out.println(str1);
		}
	   
	   
	   
}
