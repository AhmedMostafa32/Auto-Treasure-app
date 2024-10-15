package com.example.myapplication;

public class BuyCarModel {
    private String txt1;
    private String txt2;
    private int img1;
    private int img2;
    private String rate;

    public BuyCarModel(String txt1, String txt2, int img1, String rate , int img2) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.img1 = img1;
        this.rate = rate;
        this.img2 = img2;
    }

    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public int getImg1() {
        return img1;
    }

    public String getRate() {
        return rate;
    }
    public int getImg2() {
        return img2;
    }
}
