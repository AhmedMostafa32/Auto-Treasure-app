package com.example.myapplication;

public class CardModel {
    private String txt1;
    private String txt2;
    private int img;

    public CardModel(String txt1, String txt2, int img) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.img = img;
    }

    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public int getImg() {
        return img;
    }
}
