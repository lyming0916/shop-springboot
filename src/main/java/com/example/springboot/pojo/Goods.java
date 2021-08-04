package com.example.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String name;
    private String price;
    private String number;
    private String weight;
    private String date;
    private String value;
    private String introduce;
}
