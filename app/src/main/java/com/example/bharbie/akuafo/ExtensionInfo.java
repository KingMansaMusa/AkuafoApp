package com.example.bharbie.akuafo;

import io.realm.RealmObject;

/**
 * Created by BHARBIE on 4/21/2017.
 */

public class ExtensionInfo extends RealmObject {

    public String id;
    public String heading;
    public User user;
    public String info;
    public String date;

    public ExtensionInfo() {}

    public ExtensionInfo(String id, String heading, User user, String info, String date) {
        this.id = id;
        this.heading = heading;
        this.user = user;
        this.info = info;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
