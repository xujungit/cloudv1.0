package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/26
 */
@RestController
public class OrderController {
//    public static final String url="http://localhost:8001";
    private String url="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(url + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url + "/pay/get/" + id, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/del/{id}")
    public ResultData delOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(url + "/pay/get/" + id, ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(url + "/pay/get/info", String.class);
    }
}
