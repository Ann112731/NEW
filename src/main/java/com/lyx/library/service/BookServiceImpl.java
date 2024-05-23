package com.lyx.library.service;

import com.github.pagehelper.PageHelper;
import com.lyx.library.dao.BookDao;
import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> listByBookId(int book_id) {
        return bookDao.listByBookId(book_id);
    }

    @Override
    public List<Book> listByBookName(String book_name) {
        return bookDao.listByBookName(book_name);
    }

    @Override
    public List<Book> listByBookCategory(String book_category) {
        return bookDao.listByBookCategory(book_category);
    }

    @Override
    public List<Book> listAllBook() {
        return bookDao.listAllBook();
    }

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void deleteBook(int book_id) {
        bookDao.deleteBook(book_id);
    }

    @Override
    public Book selectOneBook(int book_id) {
        return bookDao.selectOneBook(book_id);
    }

    @Override
    public List<CategoryCount> countCategory() {
        return bookDao.countCategory();
    }


}
