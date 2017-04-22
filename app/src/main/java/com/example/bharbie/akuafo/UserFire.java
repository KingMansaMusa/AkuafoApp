package com.example.bharbie.akuafo;

import com.google.firebase.database.IgnoreExtraProperties;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by BHARBIE on 4/21/2017.
 */
@IgnoreExtraProperties
public class UserFire {

    public String id;;
    public String name;
    public String email;
    public String password;
    public String type;

    public UserFire() {}

    public UserFire(String id, String name, String email, String password, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
