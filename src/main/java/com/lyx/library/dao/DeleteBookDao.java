package com.lyx.library.dao;

import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import com.lyx.library.pojo.DeleteBook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeleteBookDao {
    public void insertDeleteBook(Book book);

    public DeleteBook selectOneBook(int book_id);

    public void deleteBook(int book_id);

    public List<DeleteBook> listAllBook();

    public List<CategoryCount>  countCategory();
}
