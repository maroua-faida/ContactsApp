package com.example.contactsapp;

public class user {
    private String first_name;
    private String last_name;

    private String username;
    private String birth_date;
    private String password;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public user(String first_name, String last_name, String username, String birth_date, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.birth_date = birth_date;
        this.password = password;
    }

}
