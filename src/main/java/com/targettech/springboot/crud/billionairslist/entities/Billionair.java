package com.targettech.springboot.crud.billionairslist.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Billionair{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "rank can't be null")
    private int rank;
    @NotNull(message = "networth can't be null ")
    private Double networth;
    @NotBlank(message = "companies cant be blank")
    private  String companiesowned;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Double getNetworth() {
        return networth;
    }

    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    public String getCompaniesowned() {
        return companiesowned;
    }

    public void setCompaniesowned(String companiesowned) {
        this.companiesowned = companiesowned;
    }

    @Override
    public String toString() {
        return "Billionairs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", netWorth=" + networth +
                ", companiesOwned='" + companiesowned + '\'' +
                '}';
    }
}
