package com.example.bharbie.akuafo;

import io.realm.RealmObject;

/**
 * Created by BHARBIE on 4/21/2017.
 */

public class Ads extends RealmObject {

    public String id;
    public User user;
    public int image;
    public String caption;
    public String price;
    public String description;
    public String location;
    public String category;
    public String quantity;
    public String date;
    public String phone;
    public String verifiedBy;

    public Ads() {
    }

    public Ads(String id, User user, int image, String caption, String price, String description, String location, String category, String quantity, String date, String verifiedBy, String phone) {
        this.id = id;
        this.image = image;
        this.caption = caption;
        this.price = price;
        this.description = description;
        this.location = location;
        this.category = category;
        this.quantity = quantity;
        this.date = date;
        this.verifiedBy = verifiedBy;
        this.user = user;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
