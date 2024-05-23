package com.lyx.library.service;

import com.github.pagehelper.PageInfo;
import com.lyx.library.pojo.UpdateUser;
import com.lyx.library.pojo.User;
import com.lyx.library.pojo.query.UserQuery;

import java.util.List;


public interface UserService {
    public List<User> listUser();


    public PageInfo<User> listUserByName(UserQuery userQuery);

    public void addUser(User user);

    public void updateUser(UpdateUser updateUser);


}
