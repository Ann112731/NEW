package com.lyx.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowHistory {
    private int book_id;
    private String book_name;
    private String user_name;
    private Date borrow_date;
    private Date return_date;
    private String status;
}
