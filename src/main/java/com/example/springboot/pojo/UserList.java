package com.example.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {
    private String username;
    private String email;
    private String mobile;
    private String create_time;
    private boolean mg_state;
}
