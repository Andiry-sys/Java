package org.example.Models;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private Room room;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isPaid;

    private Reservation(Builder builder) {
        this.room = builder.room;
        this.customer = builder.customer;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.isPaid = builder.isPaid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return isPaid == that.isPaid &&
                room.equals(that.room) &&
                customer.equals(that.customer) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, customer, startDate, endDate, isPaid);
    }

    public static class Builder {
        private Room room;
        private Customer customer;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean isPaid;

        public Builder room(Room room) {
            this.room = room;
            return this;
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


}
