package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/29
 */

@Configuration
public class FeignConfig {
    //配置Retryer
    @Bean
    public Retryer retryer() {
        //设置重试机制
        return Retryer.NEVER_RETRY; //这个是默认的

        //第一个参数是多长时间后开启重试机制：这里设置100ms
        //第二个参数是重试的间隔：这里设置1s一次
        //第三个参数是最大请求次数：3次【这个次数是一共的，也就是最大请求几次，而不是第一次请求失败后再请求几次】
//        return new Retryer.Default(100, 1, 3);
    }

    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;//日志级别
    }
}

