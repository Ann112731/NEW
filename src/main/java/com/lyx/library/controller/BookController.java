package com.lyx.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.library.pojo.Book;
import com.lyx.library.pojo.Borrow;
import com.lyx.library.pojo.BorrowHistory;
import com.lyx.library.pojo.CategoryCount;
import com.lyx.library.service.BookService;
import com.lyx.library.service.BoorowHistoryService;
import com.lyx.library.service.BorrowService;
import com.lyx.library.service.DeleteBookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class BookController {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private  BookService bookService;

    @Autowired
    private DeleteBookService deleteBookService;

    @Autowired
    private BoorowHistoryService boorowHistoryService;

    @RequestMapping(value = "/listbook", method = {RequestMethod.POST})
    public Map listBook(@RequestParam("book")String book,@RequestParam("select")int select,
                               @RequestParam("currentPage")int currentPage){
        HashMap<String, List> books = new HashMap<>();
        PageHelper.startPage(currentPage,4);
        switch (select){
            case 0:
                List<Book> bookList = bookService.listByBookName(book);
                PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(pageInfo.getPages());
                books.put("totalpage",integers);
                books.put("books",pageInfo.getList());
                return books;

            case 1:
                List<Book> bookList1 = bookService.listByBookId(Integer.parseInt(book));
                PageInfo<Book> pageInfo1 = new PageInfo<Book>(bookList1);
                ArrayList<Integer> integers1 = new ArrayList<>();
                integers1.add(pageInfo1.getPages());
                books.put("totalpage",integers1);
                books.put("books",pageInfo1.getList());
                return books;
            case 2:
                List<Book> bookList2 = bookService.listByBookCategory(book);
                PageInfo<Book> pageInfo2 = new PageInfo<Book>(bookList2);
                ArrayList<Integer> integers2 = new ArrayList<>();
                integers2.add(pageInfo2.getPages());
                books.put("totalpage",integers2);
                books.put("books",pageInfo2.getList());
                return books;

        }
        return books;
    }

    @RequestMapping("/listAllBook")
    public Map listAllBook(@RequestParam("currentPage") int pageNum){
        PageHelper.startPage(pageNum,5);
        HashMap<String, List> allbook = new HashMap<>();
        List<Book> list = bookService.listAllBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());
        allbook.put("totalpage",integers);
        allbook.put("all",pageInfo.getList());
        return allbook;
    }


    @RequestMapping("/listBookByPage")
    public Map listBookByPage(@RequestParam("currentPage") int pageNum,
                                     @RequestParam("create") int create){
        Map<String, List> page;
        PageHelper.startPage(pageNum,5);
        List<Book> list = bookService.listAllBook();
        PageInfo<Book> pageInfo = new PageInfo<Book>(list);
        if(create == 1){
            page = new HashMap();
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(pageInfo.getPages());
            page.put("totalpages",integers);
            page.put("books",pageInfo.getList());
            return page;
        }else{
            page = new HashMap<>();
            page.put("books",pageInfo.getList());
            return page;
        }
    }



    @RequestMapping("/insertBook")
    public String insertBook(@RequestParam("bookid")String bookid,@RequestParam("bookname")String bookname,
                             @RequestParam("bookauthor")String bookauthor,@RequestParam("bookpublish")String bookpublish,
                             @RequestParam("bookcategory")String bookcategory
                             ){
        Book book = new Book(Integer.parseInt(bookid),bookname,bookpublish,bookauthor,bookcategory);
        try {
            bookService.insertBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return "repeat";
        }
        return "success";
    }


    @RequestMapping("/borrowBook")
    public List<Book> borrowBook(@RequestParam("bookid")int book_id
            ,@RequestParam("bookname")String book_name,@RequestParam("username")String username){
        Date borrowDate = new Date();


        Calendar cal = Calendar.getInstance();
        cal.setTime(borrowDate);   //设置当前时间
        cal.add(Calendar.MONTH, 1);  //在当前时间基础上加一个月


        Date returnDate = cal.getTime();
        String status  = "未还";
        Borrow borrow = new Borrow(book_id,book_name,username,borrowDate,returnDate);
        BorrowHistory borrowHistory = new BorrowHistory(book_id,book_name,username,borrowDate,returnDate,status);
        borrowService.lendBook(borrow);
        boorowHistoryService.lendBook(borrowHistory);

        deleteBookService.inserDeleteBook(bookService.selectOneBook(book_id));
        bookService.deleteBook(book_id);
        return bookService.listAllBook();
    }

    @RequestMapping("/chart")
    public List<CategoryCount> chart(){

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
        return totalCounts;
    }

}
