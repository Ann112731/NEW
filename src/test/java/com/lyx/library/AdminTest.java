package com.lyx.library;

import com.lyx.library.Utils.Md5Utils;
import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.UpdateAdmin;
import com.lyx.library.pojo.User;
import com.lyx.library.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest
public class AdminTest {

    @Autowired
    AdminService adminService;


    @Test
    public void addAdmin(){
        Admin admin = new Admin("zhuo","12333");
        adminService.addAdmin(admin);
    }


    @Test
    public void updateAdmin(){
        UpdateAdmin updateAdmin = new UpdateAdmin("new","333","zhuo");
        adminService.updateAdmin(updateAdmin);
    }

    @Test
    public void AdminLogin(){
        Admin admin = new Admin("zhuo","12333");

        List<Admin> users = adminService.listAdmin();



        int flag = 0;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).toString().equals(admin.toString())){
                System.out.println("Success");
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            System.out.println("False!");
        }
    }
}
