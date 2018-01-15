package com.wxj.dao;

import java.util.List;
import java.util.Map;

public interface JedisClient {
        /*key */
	    //设置过期时间
	    long expire(String key,int second);
	    //获取剩余生存时间
	    long ttl(String key);
	    //删除一个key   可以删除多个   返回删除key的数量
	    long del(String key);
	
	  /*String */
	   String get(String key);
       String set(String key,String value);
       long incr(String key);//为key对应的值加1，如果为空先初始化为0再加1
       /*hash */
       String hget(String key,String field);
       List<String> hmget(String key,String...fields);
       
      
       long hset(String key,String field,String value);
       String hmset(String key, Map<String, String> map);//jedis 返回类型是string
      
       long hdel(String key,String field);
      
      
}