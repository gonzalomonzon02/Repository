package com.example.gonzalomonzon.mvvmlogin.model;

public class Login {
    public String user;
    public String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public Login(){
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
