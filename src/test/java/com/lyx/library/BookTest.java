package com.lyx.library;

import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.CategoryCount;
import com.lyx.library.service.BookService;
import com.lyx.library.service.DeleteBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class BookTest {

    @Autowired
    BookService bookService;

    @Autowired
    DeleteBookService deleteBookService;

    @Test
    public void insertBook(){
        Book book = new Book(382197, "English Book", "Amercia", "me", "教材");
        bookService.insertBook(book);
    }



    @Test
    public void deleteBook(){
        bookService.deleteBook(382197);
    }


    @Test
    public void chartTest(){
        List<CategoryCount> bookCategory = bookService.countCategory();
        List<CategoryCount> deleteBookCounts = deleteBookService.countCategory();
        ArrayList<CategoryCount> totalCounts = new ArrayList<>();
        ArrayList<CategoryCount> least = new ArrayList<>();
        if(bookCategory.size() > deleteBookCounts.size()){
            totalCounts = (ArrayList<CategoryCount>) bookCategory;
            least = (ArrayList<CategoryCount>) deleteBookCounts;
        }else if(bookCategory.size() < deleteBookCounts.size()){
            totalCounts = (ArrayList<CategoryCount>) deleteBookCounts;
            least = (ArrayList<CategoryCount>) bookCategory;
        }else if(bookCategory.size() == deleteBookCounts.size()){
            totalCounts = (ArrayList<CategoryCount>) bookCategory;
            least = (ArrayList<CategoryCount>) deleteBookCounts;
        }

        for (CategoryCount c:totalCounts){
            for (int i = 0; i < least.size(); i++) {
                if(c.getCategory().equals(least.get(i).getCategory())) {
                    c.setCount(c.getCount() + least.get(i).getCount());
                }
            }
        }

        for (int i = 0; i < totalCounts.size(); i++) {
            System.out.println(totalCounts.get(i));
        }
    }
}
