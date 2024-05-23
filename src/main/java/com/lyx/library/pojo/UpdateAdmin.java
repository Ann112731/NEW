package com.lyx.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdmin {
    private String adminname;
    private String password;
    private String oldadminname;
}
