package com.itheima.mapper;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user2 where username=#{username}")
    User select(@Param("username") String username, @Param("password")  String password);
    @Select("select * from tb_user2 where username=#{username}")
    User selectByUsername(String username);
    @Insert("insert into tb_user2 values (null,#{username},#{password})")
    void insert(User user);
    @Select("select *from tb_user2")
    List<User> selectAll();

}
