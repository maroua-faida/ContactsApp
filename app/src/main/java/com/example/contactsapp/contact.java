package com.example.contactsapp;

public class contact {

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private String first_name;
    private String last_name;
    private String job;
    private String email;
    private String tel;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    private String Key;

    public contact() {

    }
    public contact(String first_name, String last_name, String job, String email, String tel) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.job = job;
        this.email = email;
        this.tel = tel;
    }


}
