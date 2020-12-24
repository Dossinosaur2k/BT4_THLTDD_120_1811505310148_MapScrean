package com.example.ktcuoi;

import java.security.PublicKey;

public class Employee {
    private String fistname;

    public Employee(String fistname) {
        this.fistname = fistname;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }
    @Override
    public String toString() {
        return fistname;
    }
}
