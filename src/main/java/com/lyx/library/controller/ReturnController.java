package com.lyx.library.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.library.pojo.*;
import com.lyx.library.service.BookService;
import com.lyx.library.service.BoorowHistoryService;
import com.lyx.library.service.BorrowService;
import com.lyx.library.service.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
public class ReturnController {

    @Autowired
    private BoorowHistoryService boorowHistoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private DeleteBookService deleteBookService;

    @RequestMapping("/listRecord")
    public Map listRecord(@RequestParam("username")String username, @RequestParam("currentPage") int pageNum){

        PageHelper.startPage(pageNum,6);
        HashMap<String, List> recordMap = new HashMap<>();

        List<BorrowHistory> borrowHistories = boorowHistoryService.listRecord(username);

        PageInfo<BorrowHistory> pageInfo = new PageInfo<BorrowHistory>(borrowHistories);
        ArrayList<DateFormate> dateFormates = new ArrayList<>();


        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());
        recordMap.put("totalpage",integers);
        List<BorrowHistory> list = pageInfo.getList();

        for(BorrowHistory borrowHistory: list){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String borrowDate = format.format(borrowHistory.getBorrow_date());
            String returnDate = format.format(borrowHistory.getReturn_date());
            DateFormate dateFormate = new DateFormate(borrowHistory.getBook_id(), borrowHistory.getBook_name(), username, borrowDate, returnDate, borrowHistory.getStatus());
            dateFormates.add(dateFormate);
        }
        recordMap.put("record",dateFormates);

        return recordMap;
    }



    @RequestMapping("/listReturn")
    public Map listReturn(@RequestParam("username")String username
            , @RequestParam("currentPage") int pageNum){
        PageHelper.startPage(pageNum,5);
        HashMap<String, List> Map = new HashMap<>();
        List<Borrow> borrows = borrowService.listAllBorrowBook(username);
        PageInfo<Borrow> pageInfo = new PageInfo<Borrow>(borrows);
        List<Borrow> returnList = pageInfo.getList();
        List<DateFormate> dateFormates = new ArrayList<>();
        for(Borrow borrow: returnList){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String borrowDate = format.format(borrow.getBorrow_date());
            String returnDate = format.format(borrow.getReturn_date());
            DateFormate dateFormate = new DateFormate(borrow.getBook_id(), borrow.getBook_name(), username, borrowDate, returnDate);
            dateFormates.add(dateFormate);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());
        Map.put("totalpage",integers);
        Map.put("return",dateFormates);
        return Map;
    }


    @RequestMapping("/returnButton")
    public String returnBook(@RequestParam("username")String username
            ,@RequestParam("bookid")int book_id){
        DeleteBook deleteBook = deleteBookService.selectOneBook(book_id);
        Book book = new Book(deleteBook.getBook_id(), deleteBook.getBook_name(), deleteBook.getBook_publish(), deleteBook.getBook_author(), deleteBook.getBook_category());
        bookService.insertBook(book);
        deleteBookService.deleteBook(book_id);
        borrowService.returnBook(book_id);
        boorowHistoryService.setStatus(username,book_id);
        return "success";
    }




    @RequestMapping("/listAllRecord")
    public Map listAllRecord(@RequestParam("currentPage") int pageNum){
        PageHelper.startPage(pageNum,6);
        Map<String, List> allRecord = new HashMap<>();
        List<BorrowHistory> borrowHistories = boorowHistoryService.adminHistory();
        PageInfo<BorrowHistory> pageInfo = new PageInfo<BorrowHistory>(borrowHistories);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());
        ArrayList<DateFormate> dateFormates = new ArrayList<>();
        List<BorrowHistory> list = pageInfo.getList();
        for(BorrowHistory b: list){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String borrowDate = format.format(b.getBorrow_date());
            String returnDate = format.format(b.getReturn_date());
            DateFormate dateFormate = new DateFormate(b.getBook_id(), b.getBook_name(), b.getUser_name(), borrowDate, returnDate, b.getStatus());
            dateFormates.add(dateFormate);
        }

        allRecord.put("totalpage",integers);
        allRecord.put("all",dateFormates);
        return allRecord;
    }

    @RequestMapping("/listAddBook")
    public Map listAllBook(@RequestParam("currentPage") int pageNum){
        PageHelper.startPage(pageNum,6);
        Map<String, List> addBook = new HashMap<>();
        List<Book> books = bookService.listAllBook();

        PageInfo<Book> pageInfo = new PageInfo<Book>(books);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pageInfo.getPages());
        addBook.put("totalpage",integers);
        addBook.put("addBook",pageInfo.getList());
        return addBook;
    }


}
