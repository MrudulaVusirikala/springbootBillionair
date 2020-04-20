package com.targettech.springboot.crud.billionairslist.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Entity
public class Billionair{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "profilepic cant be empty")
    private String picture;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "networth can't be null ")
    private Double netWorth;
    @NotBlank(message = "companies cant be blank")
    private  String companiesOwned;
    @Lob
    private byte[] image;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Double netWorth) {
        this.netWorth = netWorth;
    }

    public String getCompaniesOwned() {
        return companiesOwned;
    }

    public void setCompaniesOwned(String companiesOwned) {
        this.companiesOwned = companiesOwned;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Billionair{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", netWorth=" + netWorth +
                ", companiesOwned='" + companiesOwned + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

}
