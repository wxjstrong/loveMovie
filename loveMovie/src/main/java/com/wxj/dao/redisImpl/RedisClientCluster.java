package com.wxj.dao.redisImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

import com.wxj.dao.JedisClient;

public class RedisClientCluster implements JedisClient{

	
	@Autowired
	JedisCluster jedisCluster ;
	
	@Override
	public long expire(String key, int second) {
		return jedisCluster.expire(key, second);
	}

	@Override
	public long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public List<String> hmget(String key, String... fields) {
		return jedisCluster.hmget(key, fields);
	}

	@Override
	public long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hmset(String key, Map<String, String> map) {
		return jedisCluster.hmset(key,  map);
	}

	@Override
	public long hdel(String key, String field) {
		return jedisCluster.hdel(key, field);
	}
	
}
