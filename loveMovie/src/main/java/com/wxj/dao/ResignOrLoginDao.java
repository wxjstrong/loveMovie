package com.wxj.dao;

import java.util.List;
import java.util.Map;

import com.wxj.entity.User;

public interface ResignOrLoginDao {
       public int addUser(User user);
       
      // public List<User> query(Map map);
       
       public String selectMaxId();
       
       public int loginUser(Map map);
}
