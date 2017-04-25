package com.example.bharbie.akuafo;

import io.realm.RealmObject;

/**
 * Created by BHARBIE on 4/21/2017.
 */

public class ExtensionInfo{

    public String id;
    public String heading;
    public UserFire userFire;
    public String info;
    public String date;

    public ExtensionInfo() {}

    public ExtensionInfo(String id, String heading, UserFire userFire, String info, String date) {
        this.id = id;
        this.heading = heading;
        this.userFire = userFire;
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

    public UserFire getUseFiler() {
        return userFire;
    }

    public void setUserFire(UserFire userFire) {
        this.userFire = userFire;
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
