package com.example.echannel;

public class HospitalDetailsModel {
    int date;
    String time;
    String datename;


    public HospitalDetailsModel(int date, String time, String datename) {
        this.date = date;
        this.time = time;
        this.datename = datename;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }



    public String getDatename() {
        return datename;
    }

    public void setDatename(String datename) {
        this.datename = datename;
    }



}
