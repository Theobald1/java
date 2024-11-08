package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService  {
    SqlSessionFactory factory=  SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<User>selcetAll(){
        SqlSession session=factory.openSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<User>users=mapper.selectAll();
        session.close();
        return users;
    }
    public User login(String username,String password){
        SqlSession sqlSession=factory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.select(username,password);
        sqlSession.close();
        return user;
    }
}
