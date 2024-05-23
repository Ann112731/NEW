package com.lyx.library.service;

import com.github.pagehelper.PageInfo;
import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.UpdateAdmin;
import com.lyx.library.pojo.User;
import com.lyx.library.pojo.query.UserQuery;

import java.util.List;


public interface AdminService {

    public List<Admin> listAdmin();

    public void addAdmin(Admin admin);

    public void updateAdmin(UpdateAdmin updateAdmin);
}
