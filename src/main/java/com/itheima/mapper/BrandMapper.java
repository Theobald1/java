package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    @Select("select *from tb_brand")
    List<Brand> selectAll();
}
