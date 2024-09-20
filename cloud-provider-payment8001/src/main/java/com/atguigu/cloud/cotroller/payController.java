package com.atguigu.cloud.cotroller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author: xujun
 * @updateUser: xujun
 * @date: 2024/8/24
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支持CURD")
public class payController {
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json作为参数")
    public ResultData<String> addPay(@RequestBody Pay pay){
        System.out.println(pay);
        int re = payService.add(pay);
//        return "成功插入记录" + re;
        return ResultData.success("成功插入记录" + re);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法,int作为参数")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "更新", description = "更新支付流水方法,json作为参数")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按ID查找", description = "查找支付流水方法,int作为参数")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        //test
//        if(id == -4) throw new RuntimeException("test Exception");

        // test bug
//        try {
//            TimeUnit.SECONDS.sleep(62);
//        }catch (InterruptedException e){
//            System.out.println(e.getMessage());
//        }

        return ResultData.success(payService.getById(id));
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查找全部", description = "查找所有支付流水方法,无需参数")
    public ResultData<List<Pay>> getAll(){
        return ResultData.success(payService.getAll());
    }


    @Value("${server.port}$")
    private String port;

    //从consul中获取
    @GetMapping(value = "/pay/get/info")
    public ResultData<String>  getConsul(@Value("${atguigu.info}") String info) {
        return ResultData.success("atguiguInfo: "+ info + "\t当前端口号 " + port);
    }
}
