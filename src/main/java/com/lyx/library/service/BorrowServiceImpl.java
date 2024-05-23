package com.lyx.library.service;

import com.lyx.library.dao.BookDao;
import com.lyx.library.dao.BoorowDao;
import com.lyx.library.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    private BoorowDao boorowDao;

    @Override
    public void lendBook(Borrow borrow) {
        boorowDao.lendBook(borrow);
    }

    @Override
    public void returnBook(int book_id) {
        boorowDao.returnBook(book_id);
    }

    @Override
    public List<Borrow> listAllBorrowBook(String user_name) {
        return boorowDao.listAllBorrowBook(user_name);
    }

    @Override
    public void updateUser(String old_name, String new_name) {
        boorowDao.updateUser(old_name,new_name);
    }
}
