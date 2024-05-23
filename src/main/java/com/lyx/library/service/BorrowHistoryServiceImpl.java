package com.lyx.library.service;

import com.lyx.library.dao.BorrowHistoryDao;
import com.lyx.library.pojo.BorrowHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BorrowHistoryServiceImpl implements BoorowHistoryService{

    @Autowired
    private  BorrowHistoryDao borrowHistoryDao;

    @Override
    public void lendBook(BorrowHistory borrowHistory) {
        borrowHistoryDao.lendBook(borrowHistory);
    }

    @Override
    public void setStatus(String user_name,int book_id) {
        borrowHistoryDao.setStatus(user_name,book_id);
    }

    @Override
    public List<BorrowHistory> listRecord(String username) {
        return borrowHistoryDao.listRecord(username);
    }

    @Override
    public void updateUser(String old_name, String new_name) {
        borrowHistoryDao.updateUser(old_name,new_name);
    }

    @Override
    public  List<BorrowHistory> adminHistory() {
        return borrowHistoryDao.adminHistory();
    }
}
