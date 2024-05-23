package com.lyx.library.service;

import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;

import java.util.List;
import java.util.Map;


public interface BookService {
    public List<Book> listByBookId(int bookid);

    public List<Book> listByBookName(String bookname);

    public List<Book> listByBookCategory(String bookcategory);

    public List<Book> listAllBook();

    public void insertBook(Book book);

    public void deleteBook(int book_id);

    public Book selectOneBook(int book_id);

    public List<CategoryCount>  countCategory();
}
