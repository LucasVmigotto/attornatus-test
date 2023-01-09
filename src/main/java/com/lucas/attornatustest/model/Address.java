package com.lucas.attornatustest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import com.lucas.attornatustest.model.Person;

@Entity
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String zip;

    @Column
    private String street;

    @Column
    private int number;

    @Column
    private String city;

    @Column
    private String state;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Person person;

    public Address() {}

    public Address(Long id, String zip, String street, int number, String city, String state) {
        this.id = id;
        this.zip = zip;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address [" +
        " ZIP: " + this.zip +
        " Street: " + this.street +
        " Number: " + this.number +
        " City: " + this.city +
        " State: " + this.state +
        " ]";
    }
}
