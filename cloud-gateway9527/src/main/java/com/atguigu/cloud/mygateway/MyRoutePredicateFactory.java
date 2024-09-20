package com.atguigu.cloud.mygateway;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *  需求说明: 自定义配置会员等级userType, 按照钻/金/银和yml进行配置会员等级
 *  自定义配置会员等级userType, 按照钻/金/银和yml进行配置会员等级
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/9/7
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory() {
        super(MyRoutePredicateFactory.Config.class);
    }

    // 这个Config类就是我们的路由断言规则, 重要
    @Validated
    public static class Config {
        @NotNull@Setter@Getter
        private String userType;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if(null == userType){
                    return false;
                }

                if(userType.equalsIgnoreCase(config.getUserType())){
                    return true;
                }

                return false;
            }
        };
    }
}
