package com.lyx.library;

import com.lyx.library.Utils.Md5Utils;
import com.lyx.library.pojo.UpdateUser;
import com.lyx.library.pojo.User;
import com.lyx.library.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;


    @Test
    void addUser() {
        User user = new User("Jack", Md5Utils.MD5("112233"));
        userService.addUser(user);

    }


    @Test
    void uodateUser() {
        List<User> users = userService.listUser();

        User niunn = new User("niunn", Md5Utils.MD5("123456"));

        int flag = 0;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).toString().equals(niunn)){
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
