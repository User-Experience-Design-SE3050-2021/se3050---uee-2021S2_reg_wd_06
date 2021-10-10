package com.example.echannel;

public class HospitalModel {
    int image1;
    int image2;
    String hospital;
    String test;
    String address;

    public HospitalModel(int image1, int image2, String hospital, String test, String address) {
        this.image1 = image1;
        this.image2 = image2;
        this.hospital = hospital;
        this.test = test;
        this.address = address;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
