package com.lyx.library.service;

import com.lyx.library.dao.DeleteBookDao;
import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import com.lyx.library.pojo.DeleteBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeleteBookServiceImpl implements DeleteBookService{
    @Autowired
    private DeleteBookDao deleteBookDao;

    @Override
    public void inserDeleteBook(Book book) {
        deleteBookDao.insertDeleteBook(book);
    }

    @Override
    public DeleteBook selectOneBook(int book_id) {
        return deleteBookDao.selectOneBook(book_id);
    }



    @Override
    public void deleteBook(int book_id) {
        deleteBookDao.deleteBook(book_id);
    }

    @Override
    public List<DeleteBook> listAllBook() {
        return deleteBookDao.listAllBook();
    }

    @Override
    public List<CategoryCount> countCategory() {
        return  deleteBookDao.countCategory();
    }
}
