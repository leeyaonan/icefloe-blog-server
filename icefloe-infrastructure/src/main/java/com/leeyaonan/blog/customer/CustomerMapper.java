package com.leeyaonan.blog.customer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper{

  @Select("select * from customer where id = 1")
  CustomerDO getByById(String customerId);
}
