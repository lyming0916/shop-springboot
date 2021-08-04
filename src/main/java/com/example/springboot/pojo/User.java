package com.example.springboot.pojo;


public class User {
    private String name;
    private String password;

    public String getId() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setId(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
