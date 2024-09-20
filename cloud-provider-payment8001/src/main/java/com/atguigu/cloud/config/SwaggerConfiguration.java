package com.atguigu.cloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Swagger3的配置类
 *  主要功能是配置Swagger3及其访问API的主要内容
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/25
 */

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi PayApi()
    {
        //以/pay开头的请求都是支付模块
        return GroupedOpenApi.builder().group("支付微服务模块").pathsToMatch("/pay/**").build();
    }
    @Bean
    public GroupedOpenApi OtherApi()
    {
        //以/other开头的都是其他模块的请求
        return GroupedOpenApi.builder().group("其它微服务模块").pathsToMatch("/other/**", "/others").build();
    }

    @Bean
    public OpenAPI docsOpenApi()
    {
        return new OpenAPI()
                .info(new Info().title("cloud2024")
                        .description("通用设计rest")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("www.baidu.com")
                        .url("https://yiyan.baidu.com/"));
    }
}

