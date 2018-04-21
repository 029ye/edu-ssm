package com.ye.dao;

import com.ye.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
     List<User> getList();
     @Select("select * from user where id=#{id}")
     User getById(@Param("id") Integer id);
}
