package org.example.builder;

import org.example.Models.Customer;
import org.example.Models.Reservation;
import org.example.Models.Room;

import java.time.LocalDate;

public class Builder {
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPaid;

    public Builder room(Room room) {
        this.room = room;
        return this;
    }

    public Room getRoom(){
        return  this.room;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public LocalDate getStartDate(){
        return  this.startDate;
    }

    public LocalDate getEndDate(){
        return  this.endDate;
    }

    public  boolean getIsPaid(){
        return this.isPaid;
    }


    public Builder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Builder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Builder endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Builder isPaid(boolean isPaid) {
        this.isPaid = isPaid;
        return this;
    }



    public Reservation build() {
        return new Reservation(this);
    }
}
