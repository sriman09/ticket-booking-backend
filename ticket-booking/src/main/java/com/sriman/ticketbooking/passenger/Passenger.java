package com.sriman.ticketbooking.passenger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sriman.ticketbooking.ticket.Ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int age;
    private String gender;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
