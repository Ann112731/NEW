package com.lyx.library.service;

import com.lyx.library.pojo.Borrow;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BorrowService {
    public void lendBook(Borrow borrow);

    public void returnBook(int book_id);

    public List<Borrow> listAllBorrowBook(String user_name);
    public void updateUser(String old_name,String new_name);
}
