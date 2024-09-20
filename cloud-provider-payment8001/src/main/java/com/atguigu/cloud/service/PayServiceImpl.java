package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/24
 */
@Service
public class PayServiceImpl implements PayService{

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
