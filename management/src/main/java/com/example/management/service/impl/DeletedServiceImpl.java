package com.example.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.management.mapper.CustomerMapper;
import com.example.management.mapper.LogMapper;
import com.example.management.pojo.Customer;
import com.example.management.pojo.Deleted;
import com.example.management.mapper.DeletedMapper;
import com.example.management.pojo.Log;
import com.example.management.service.DeletedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.nio.file.Watchable;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zerowo
 * @since 2023-04-16
 */
@Service
public class DeletedServiceImpl extends ServiceImpl<DeletedMapper, Deleted> implements DeletedService {
    @Autowired(required = false)
    private DeletedMapper deletedMapper;

    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Autowired(required = false)
    private LogMapper logMapper;

    @Override
    public CommonResult restore(Deleted deleted) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("customerId",deleted.getCustomerId());
        Deleted deleted1 = deletedMapper.selectOne(wrapper);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Customer customer = new Customer();
        Log log = new Log();
        customer.setCustomerName(deleted1.getCustomerName());
        customer.setCustomerEmail(deleted1.getCustomerEmail());
        customer.setCustomerAddress(deleted1.getCustomerAddress());
        customer.setChargeStaff(deleted1.getChargeStaff());
        customer.setCustomerGender(deleted1.getCustomerGender());
        customer.setCustomerJob(deleted1.getCustomerJob());
        customer.setCustomerQQ(deleted1.getCustomerQQ());
        customer.setNickname(deleted1.getNickname());
        customer.setCustomerJointime(sdf.format(System.currentTimeMillis()));
        log.setStaffId(deleted1.getStaffId());
        log.setStaffName(deleted1.getStaffName());
        log.setCustomerId(customer.getCustomerId());
        log.setCustomerName(customer.getCustomerName());
        log.setTime(sdf.format(System.currentTimeMillis()));
        log.setStaffName(deleted1.getStaffName());
        log.setOperation("恢复");
        customerMapper.insert(customer);
        logMapper.insert(log);
        deletedMapper.deleteById(deleted1.getCustomerId());
        return CommonResult.success();
    }

    @Override
    public CommonResult allDelete(String staffId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("staffId",staffId);
        List list = deletedMapper.selectList(wrapper);
        return CommonResult.success(list);
    }
}