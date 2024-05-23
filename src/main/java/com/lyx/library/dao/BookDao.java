package com.lyx.library.dao;

import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BookDao {
    public List<Book> listByBookId(int book_id);

    public List<Book> listByBookName(String book_name);

    public List<Book> listByBookCategory(String book_category);

    public List<Book> listAllBook();

    public void insertBook(Book book);

    public void deleteBook(int book_id);


    public Book selectOneBook(int book_id);

    public List<CategoryCount>  countCategory();
}
