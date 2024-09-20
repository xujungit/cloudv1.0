package com.atguigu.cloud.service;

import com.atguigu.cloud.mapper.StorageMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class StorageServiceImpl implements StorageService{
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");

    }
}
