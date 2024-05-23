package com.lyx.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateFormate {
    private int book_id;
    private String book_name;
    private String user_name;
    private String borrow_date;
    private String return_date;
    private String status;

    public DateFormate(int book_id, String book_name, String user_name, String borrow_date, String return_date) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.user_name = user_name;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }
}
