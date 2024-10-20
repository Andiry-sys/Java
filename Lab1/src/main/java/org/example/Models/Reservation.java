package org.example.Models;

import java.time.LocalDate;
import org.example.builder.Builder;

public class Reservation {
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPaid;

    public Reservation(Builder builder) {
        this.room = builder.getRoom();
        this.customer = builder.getCustomer();
        this.startDate = builder.getStartDate();
        this.endDate = builder.getEndDate();
        this.isPaid = builder.getIsPaid();
    }

    // Getters
    public LocalDate getStartDate() {
        return startDate;  // Add this getter method
    }

    public LocalDate getEndDate() {
        return endDate;    // Add this getter method
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", customer=" + customer +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isPaid=" + isPaid +
                '}';
    }
}
