package com.atguigu.cloud.service;

import com.atguigu.cloud.mapper.AccountMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/9/19
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService
{
    @Resource
    AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");

        accountMapper.decrease(userId,money);

         myTimeOut();
//        int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }

    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut()
    {
        try { TimeUnit.SECONDS.sleep(65); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
