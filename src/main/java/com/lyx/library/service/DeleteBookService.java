package com.lyx.library.service;

import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import com.lyx.library.pojo.DeleteBook;

import java.util.List;


public interface DeleteBookService {
    public void inserDeleteBook(Book book);
    public DeleteBook selectOneBook(int book_id);

    public void deleteBook(int book_id);

    public List<DeleteBook> listAllBook();

    public List<CategoryCount>  countCategory();
}
