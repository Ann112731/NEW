package com.lyx.library.service;

import com.lyx.library.pojo.BorrowHistory;

import java.util.List;

public interface BoorowHistoryService {
    public void lendBook(BorrowHistory borrowHistory);
    public void setStatus(String user_name,int book_id);
    public List<BorrowHistory> listRecord(String username);
    public void updateUser(String old_name,String new_name);
    public List<BorrowHistory> adminHistory();
}
