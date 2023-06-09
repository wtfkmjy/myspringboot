package com.example.management.controller;


import com.example.management.pojo.po.Deleted;
import com.example.management.service.DeletedService;
import com.example.management.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zerowo
 * @since 2023-04-16
 */
@RestController
@RequestMapping("/deleted")
@CrossOrigin
public class DeletedController {
    @Autowired
    private DeletedService deletedService;

    @PreAuthorize("hasAuthority('恢复删除')")
    @PostMapping("/restore")
    public CommonResult restore(@RequestBody Deleted deleted){
        return deletedService.restore(deleted);
    }

    @PreAuthorize("hasAuthority('删除客户')")
    @PostMapping("/all")
    public CommonResult allDelete(@RequestBody String staffId){
        return deletedService.allDelete(staffId);
    }
}

