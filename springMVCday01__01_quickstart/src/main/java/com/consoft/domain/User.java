package com.consoft.domain;

import java.util.Date;

public class User {

    private String uname;
    private String uword;
    private Date date;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUword() {
        return uword;
    }

    public void setUword(String uword) {
        this.uword = uword;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", uword='" + uword + '\'' +
                ", date=" + date +
                '}';
    }
}
