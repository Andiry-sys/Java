package org.example;

import org.example.Models.Customer;
import org.example.Models.Reservation;
import org.example.Models.Room;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Room room = new Room("Suite", 2, 101, "WiFi, TV, Air Conditioning");
        Customer customer = new Customer("Doe", "John", "ID123456", LocalDate.of(1990, 5, 15));

        Reservation reservation = new Reservation.Builder()
                .room(room)
                .customer(customer)
                .startDate(LocalDate.of(2024, 10, 20))
                .endDate(LocalDate.of(2024, 10, 25))
                .isPaid(true)
                .build();

        System.out.println(reservation);
    }
}