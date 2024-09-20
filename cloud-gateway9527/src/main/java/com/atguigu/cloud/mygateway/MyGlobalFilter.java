package com.atguigu.cloud.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/9/9
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    public static final String BEGIN_VISITED_TIME = "begin_visited_time";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1、先记录下访问接口的开始时间
        exchange.getAttributes().put(BEGIN_VISITED_TIME, System.currentTimeMillis());
        // 2、返回统计的结果给后台
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginTime = exchange.getAttribute(BEGIN_VISITED_TIME);

            if(beginTime != null){
                log.info("=================================================================");
                log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
                log.info("访问接口URL后面的参数: " + exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口时长: " + (System.currentTimeMillis() - beginTime) + "毫秒");
                log.info("=================================================================");
                System.out.println();
            }
        }));
    }

    /**
     * 数字越小, 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
