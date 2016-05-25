package com.internousdev.prototype1605.dto;

public class LoginDTO{
    private int id;
    private String user_name;
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return user_name;
    }
    public void setName(String name) {
        this.user_name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}