package com.wxj.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil extends Properties{

	
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);  
	//私有的静态的对象
	private static PropertiesUtil instance =null;
     
	//私有的的构造方法
	private PropertiesUtil(String path){
		InputStream is = null;
		try {
			is = this.getClass().getResourceAsStream(path);
			System.out.println(this.getClass());
			load(is);
		} catch (IOException e) {
			logger.error("读取配置文件出错:"+e);
		}
		finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					logger.error("关闭输入流异常："+e);
				}
			}
		}
	};
	//创建对象实例
	public static PropertiesUtil getInstance(String path){
	
		if(instance !=null){
			return instance;
		}else{
			putInstance(path);
			return instance;
		}
	}
	
	
	private static synchronized void putInstance(String path){
		if(instance == null){
			instance = new PropertiesUtil(path);
		}
	}
	
	
	public static void main(String[] args) {
		logger.debug("开始读取属性文件");
		getInstance("/jdbc.properties");
	}
	
}
