package com.example.management.service;

import com.example.management.pojo.po.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.management.utils.CommonResult;

public interface StaffService extends IService<Staff> {

    CommonResult selectAll();

    CommonResult selectByDepartment(String departmentName);

    CommonResult selectByJob(Staff staff);

    CommonResult setAccount(Staff staff);

    CommonResult updateStaff(Staff staff);

    CommonResult setActive(String staffId, int isActive);
}
