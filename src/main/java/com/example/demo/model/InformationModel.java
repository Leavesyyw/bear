package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class InformationModel {
    @Id
    @GeneratedValue
    private int infid;
    private String  username;
    private int icestatue=1;
    private int goldamount=0;
    private int count=1;

    public InformationModel() {
    }

    public int getInfid() {
        return infid;
    }

    public void setInfid(int infid) {
        this.infid = infid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setGoldamount(){
        this.goldamount++;
    }

    public void setIcestatue(){
        this.icestatue++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
