package com.wxj.service;

import java.util.Map;

import com.wxj.entity.User;

public interface ResignOrLoginService {
       public String resign(User user);
       public String login(Map map);
}
