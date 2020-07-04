package com.example.foodorder_driver.Model;

import java.util.List;

public class Request {
    public String name;
    public String phone;
    public String total;
    public String address;
    public String status;
    public Request(){}

    public Request(String name, String phone, String total, String address, String status) {
        this.name = name;
        this.phone = phone;
        this.total = total;
        this.address = address;
        this.status=status;

    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

