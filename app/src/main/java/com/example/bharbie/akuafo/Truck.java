package com.example.bharbie.akuafo;

import io.realm.RealmObject;

/**
 * Created by BHARBIE on 4/21/2017.
 */

public class Truck extends RealmObject {

    public String id;
    public User user;
    public int image;
    public String model;
    public String phone;
    public String size;
    public String regNo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String date;

    public Truck() {}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Truck(String id, User user, int image, String model, String size, String regNo, String date, String phone) {
        this.id = id;
        this.phone = phone;
        this.image = image;
        this.model = model;
        this.size = size;
        this.regNo = regNo;
        this.date = date;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
