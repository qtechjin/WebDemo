package com.ustcjin.domain;

/**
 * Created by mi on 2017/1/23.
 */
public class Order {
    private String orderId;
    private String userName;
    private String goodName;
    private int count;

    public Order(String orderId, String userName, String goodName, int count) {
        this.orderId = orderId;
        this.userName = userName;
        this.goodName = goodName;
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
