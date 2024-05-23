package com.lyx.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int book_id;
    private String book_name;
    private String book_publish;
    private String book_author;
    private String book_category;
}
