package com.lyx.library.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 2;
    private String name;
}
