package com.lyx.library.dao;

import com.lyx.library.pojo.UpdateUser;
import com.lyx.library.pojo.User;
import com.lyx.library.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface UserDao {
    public List<User> listUser();


    public List<User> listUserByName(UserQuery userQuery);


    public void addUser(User user);

    public void updateUser(UpdateUser updateUser);
}
