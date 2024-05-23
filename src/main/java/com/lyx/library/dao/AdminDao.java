package com.lyx.library.dao;

import com.lyx.library.pojo.Admin;
import com.lyx.library.pojo.UpdateAdmin;
import com.lyx.library.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AdminDao {
    public List<Admin> listAdmin();


    public void addAdmin(Admin admin);

    public void updateAdmin(UpdateAdmin updateAdmin);

}
