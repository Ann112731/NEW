package com.lyx.library.service;

import com.lyx.library.dao.AdminDao;
import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.UpdateAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> listAdmin() {
        return adminDao.listAdmin();
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDao.addAdmin(admin);
    }

    @Override
    public void updateAdmin(UpdateAdmin updateAdmin) {
        adminDao.updateAdmin(updateAdmin);
    }
}
