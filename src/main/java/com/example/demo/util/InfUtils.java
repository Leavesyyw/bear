package com.example.demo.util;

public class InfUtils {
    protected String mes;
    protected int icestatue;
    protected int goldamount;
    protected int count;

    public InfUtils(String mes, int icestatue, int goldamount, int count) {
        this.mes = mes;
        this.icestatue = icestatue;
        this.goldamount = goldamount;
        this.count = count;
    }

    public InfUtils() {
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getIcestatue() {
        return icestatue;
    }

    public void setIcestatue(int icestatue) {
        this.icestatue = icestatue;
    }

    public int getGoldamount() {
        return goldamount;
    }

    public void setGoldamount(int goldamount) {
        this.goldamount = goldamount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
