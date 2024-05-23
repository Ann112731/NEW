package com.lyx.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.library.Utils.Md5Utils;
import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.UpdateUser;
import com.lyx.library.pojo.User;
import com.lyx.library.service.AdminService;
import com.lyx.library.service.BoorowHistoryService;
import com.lyx.library.service.BorrowService;
import com.lyx.library.service.UserService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.lyx.library.Utils.Md5Utils.MD5;



@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BoorowHistoryService boorowHistoryService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest request,
                        HttpServletResponse response, @RequestParam("uid")String username,
                        @RequestParam("pwd")String password, @RequestParam("choose")String choose){
        HttpSession session = request.getSession();
        if(choose.equals("u")){
            List<User> users = userService.listUser();
            User user = new User(username, Md5Utils.MD5(password));
            for (int i = 0; i < users.size(); i++) {
                if(user.toString().equals(users.get(i).toString())){
                    String uuid = UUID.randomUUID().toString();
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("token", uuid);
                    Cookie newCookie = new Cookie("token", uuid);
                    //cookie有效时间 单位秒 设置5分钟
                    newCookie.setMaxAge(900);
                    //放回response
                    response.addCookie(newCookie);
                    Cookie newCookie2 = new Cookie("username", user.getUsername());
                    //cookie有效时间 单位秒 设置5分钟
                    newCookie2.setMaxAge(900);
                    //放回response
                    response.addCookie(newCookie2);
                    return "success";
                }
            }
            return "no";
        }else if(choose.equals("a")){
            List<Admin> admins = adminService.listAdmin();
            Admin admin = new Admin(username, password);
            for (int i = 0; i < admins.size(); i++) {
                System.out.println(admins.get(i).toString());
                if(admin.toString().equals(admins.get(i).toString())){
                    String uuid = UUID.randomUUID().toString();
                    session.setAttribute("adminname", admin.getAdminname());
                    session.setAttribute("token", uuid);
                    Cookie newCookie = new Cookie("token", uuid);
                    //cookie有效时间 单位秒 设置5分钟
                    newCookie.setMaxAge(900);
                    //放回response
                    response.addCookie(newCookie);
                    Cookie newCookie2 = new Cookie("adminname", admin.getAdminname());
                    //cookie有效时间 单位秒 设置5分钟
                    newCookie2.setMaxAge(900);
                    //放回response
                    response.addCookie(newCookie2);
                    return "success";
                }
            }
            return "no";
        }
        return "no";
    }

        @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String updateLogin(HttpServletRequest request,
                              HttpServletResponse response, @RequestParam("username")String username,
                              @RequestParam("pwd")String password){

        List<User> users = userService.listUser();
        User user = new User(username, Md5Utils.MD5(password));
        for (int i = 0; i < users.size(); i++) {
            if(user.toString().equals(users.get(i).toString())){

                return "success";
            }
        }
        return "no";
    }


    @RequestMapping(value = "/updateSuccess", method = {RequestMethod.POST})
    public String update(HttpServletRequest request,
                              HttpServletResponse response, @RequestParam("new_username")String username,
                              @RequestParam("new_pwd")String password,@RequestParam("old_username")String oldusername){
        UpdateUser newUser = new UpdateUser(username, Md5Utils.MD5(password),oldusername);
        userService.updateUser(newUser);
        System.out.println("修改成功");
        borrowService.updateUser(oldusername,username);
        boorowHistoryService.updateUser(oldusername,username);
        return "success";
    }


    @RequestMapping(value = "/regist", method = {RequestMethod.POST})
    public String regist(@RequestParam("uid2")String uid,
                        @RequestParam("pwd2")String pwd){
        User user = new User(uid, Md5Utils.MD5(pwd));
        userService.addUser(user);
        return "success";
    }


    @RequestMapping("/listAdmin")
    public Map listAdmin(@RequestParam("currentPage") int pageNum){
        PageHelper.startPage(pageNum,3);
        HashMap<String, List> Map = new HashMap<>();
        List<Admin> admins = adminService.listAdmin();
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(admins);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());

        Map.put("totalpage",integers);
        Map.put("admin",pageInfo.getList());

        return Map;
    }
}
