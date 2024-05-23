package com.lyx.library.controller;

import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.UpdateAdmin;
import com.lyx.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;

    @RequestMapping("/updateAdmin")
    public String updateAdmin(@RequestParam("oldAdmin")String oldAdmin
    ,@RequestParam("newAdmin")String newAdmin,@RequestParam("newPwd")String newPwd){
        UpdateAdmin updateAdmin = new UpdateAdmin(newAdmin, newPwd, oldAdmin);
        adminService.updateAdmin(updateAdmin);
        return "success";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(@RequestParam("addAdmin")String addAdmin,@RequestParam("addPwd")String addPwd){
        Admin admin = new Admin(addAdmin, addPwd);
        adminService.addAdmin(admin);
        return "success";
    }
}
