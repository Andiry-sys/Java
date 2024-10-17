package org.example;

import org.example.Models.Customer;
import org.example.Models.Reservation;
import org.example.Models.Room;
import org.example.service.ReservationService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room("Single", 1, 101, "WiFi, TV");
        Room room2 = new Room("Double", 2, 102, "WiFi, TV, Mini Bar");
        Room room3 = new Room("Suite", 3, 201, "WiFi, TV, Air Conditioning, Mini Bar");

        Customer customer1 = new Customer("Doe", "John", "ID123456", LocalDate.of(1990, 5, 15));
        Customer customer2 = new Customer("Smith", "Jane", "ID654321", LocalDate.of(1985, 10, 20));

        Reservation reservation1 = new Reservation.Builder()
                .room(room1)
                .customer(customer1)
                .startDate(LocalDate.of(2024, 10, 20))
                .endDate(LocalDate.of(2024, 10, 25))
                .isPaid(true)
                .build();

        Reservation reservation2 = new Reservation.Builder()
                .room(room2)
                .customer(customer2)
                .startDate(LocalDate.of(2024, 11, 1))
                .endDate(LocalDate.of(2024, 11, 5))
                .isPaid(false)
                .build();

        Reservation reservation3 = new Reservation.Builder()
                .room(room3)
                .customer(customer1)
                .startDate(LocalDate.of(2024, 12, 15))
                .endDate(LocalDate.of(2024, 12, 20))
                .isPaid(true)
                .build();

        List<Room> rooms = Arrays.asList(room1, room2, room3);
        List<Reservation> reservations = Arrays.asList(reservation1, reservation2, reservation3);

        ReservationService service = new ReservationService();

        // 1. Find all reservations by customer1
        List<Reservation> johnsReservations = service.findReservationsByCustomer(reservations, customer1);
        System.out.println("Reservations by John Doe: " + johnsReservations);

        // 2. Sort rooms by bed count and room number
        List<Room> sortedRooms = service.sortRoomsByBedCountAndNumber(rooms);
        System.out.println("Sorted rooms: " + sortedRooms);

        // 3. Find all paid reservations
        List<Reservation> paidReservations = service.findPaidReservations(reservations);
        System.out.println("Paid reservations: " + paidReservations);
    }
    }
