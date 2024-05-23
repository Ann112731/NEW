package com.lyx.library.dao;

import com.lyx.library.pojo.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface BoorowDao {
    public void lendBook(Borrow borrow);

    public void returnBook(int book_id);

    public List<Borrow> listAllBorrowBook(String username);

    public void updateUser(String old_name,String new_name);
}
