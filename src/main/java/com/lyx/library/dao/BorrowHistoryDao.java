package com.lyx.library.dao;

import com.lyx.library.pojo.Borrow;
import com.lyx.library.pojo.BorrowHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface BorrowHistoryDao {
    public void lendBook(BorrowHistory borrowHistory);
    public void setStatus(String user_name,int book_id);
    public List<BorrowHistory> listRecord(String username);
    public void updateUser(String old_name,String new_name);
    public List<BorrowHistory> adminHistory();
}
