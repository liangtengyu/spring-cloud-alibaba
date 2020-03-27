package com.lty.springcloud.controller;


import com.lty.cloudapicommons.entity.CommonResult;
import com.lty.cloudapicommons.entity.Payment;
import com.lty.springcloud.dao.PaymentDao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;

    @Value("${test.name}")
    String name;


@Resource
    PaymentDao paymentDao;

    @GetMapping("/test")
    public CommonResult test() {
        log.info(name);
            return new CommonResult(444, name);

    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentDao.create(payment);
        log.info(""+result);

        if (result > 0) {
            return new CommonResult(200, "success  "+ port,result);
        } else {
            return new CommonResult(444, "failed");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id) {

        Payment paymentById = paymentDao.getPaymentById(id);
        log.info(""+paymentById);

        if (paymentById != null) {
            return new CommonResult(200, "get success",paymentById);
        } else {
            return new CommonResult(444, "failed");
        }
    }
}
