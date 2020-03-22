package com.lty.springcloud.dao;


import com.lty.cloudapicommons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    Payment getPaymentById(@Param("id") long id);

}
