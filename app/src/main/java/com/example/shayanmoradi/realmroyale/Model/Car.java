package com.example.shayanmoradi.realmroyale.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Car extends RealmObject {

    private String carName;
    private String ownerName;
    private boolean isluxary;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isIsluxary() {
        return isluxary;
    }

    public void setIsluxary(boolean isluxary) {
        this.isluxary = isluxary;
    }
}
