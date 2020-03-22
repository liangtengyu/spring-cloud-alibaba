package com.lty.springcloud.controller;


import com.lty.cloudapicommons.entity.CommonResult;
import com.lty.cloudapicommons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OderController {
    public static final String url = "http://cloud-provider-service";

    @Resource
    RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public ResponseEntity<CommonResult> create(Payment payment){
        return restTemplate.postForEntity(url + "/payment/create", payment, CommonResult.class);

    }

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseEntity<CommonResult> get(@PathVariable("id") long id){
        return restTemplate.getForEntity(url + "/payment/get/"+id,  CommonResult.class);

    }
}
