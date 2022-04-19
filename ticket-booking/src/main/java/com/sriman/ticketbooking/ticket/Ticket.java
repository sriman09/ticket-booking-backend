package com.sriman.ticketbooking.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sriman.ticketbooking.passenger.Passenger;
import com.sriman.ticketbooking.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;

    private String origin;
    private String destination;
    private String date;
    private int price;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "ticket")
    private List<Passenger> passenger;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", user=" + user +
                '}';
    }
}
