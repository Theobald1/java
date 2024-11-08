package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory=  SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selcetAll(){
        SqlSession session=factory.openSession();
        BrandMapper mapper=session.getMapper(BrandMapper.class);
        List<Brand>brands=mapper.selectAll();
        session.close();
        return brands;
    }
}
