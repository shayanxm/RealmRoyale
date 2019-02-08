package com.example.shayanmoradi.realmroyale.Model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Customer extends RealmObject {
    @PrimaryKey
    private  String key;
    private String name;
    private int age;
    public RealmList<Car> custoemrsCars;

    public RealmList<Car> getCustoemrsCars() {
        return custoemrsCars;
    }

    public void setCustoemrsCars(RealmList<Car> custoemrsCars) {
        this.custoemrsCars = custoemrsCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
