
package org.example.service;
import org.example.Models.Customer;
import  org.example.Models.Reservation;
import org.example.Models.Room;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationService {
    /**
     * Finds all reservations for a given customer.
     *
     * @param reservations List of all reservations.
     * @param customer The customer whose reservations we want to find.
     * @return List of reservations made by the customer.
     */
    public List<Reservation> findReservationsByCustomer(List<Reservation> reservations, Customer customer) {
        return reservations.stream()
                .filter(reservation -> reservation.getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

    /**
     * Sorts a list of rooms by number of beds and then by room number.
     *
     * @param rooms List of rooms.
     * @return Sorted list of rooms.
     */
    public List<Room> sortRoomsByBedCountAndNumber(List<Room> rooms) {
        return rooms.stream()
                .sorted(Comparator.comparingInt(Room::getBedCount)
                        .thenComparing(Room::getRoomNumber))
                .collect(Collectors.toList());
    }

    /**
     * Finds all paid reservations.
     *
     * @param reservations List of all reservations.
     * @return List of paid reservations.
     */
    public List<Reservation> findPaidReservations(List<Reservation> reservations) {
        return reservations.stream()
                .filter(Reservation::isPaid)
                .collect(Collectors.toList());
    }

    /**
     * Counts total number of reservations for a specific room type.
     *
     * @param reservations List of all reservations.
     * @param roomType The type of room to filter reservations.
     * @return Total count of reservations for the given room type.
     */
    public long countReservationsByRoomType(List<Reservation> reservations, String roomType) {
        return reservations.stream()
                .filter(reservation -> reservation.getRoom().getType().equalsIgnoreCase(roomType))
                .count();
    }

    /**
     * Gets a list of customers who made reservations within a specific date range.
     *
     * @param reservations List of all reservations.
     * @param startDate Start date of the range.
     * @param endDate End date of the range.
     * @return Set of customers who made reservations within the date range.
     */
    public Set<Customer> getCustomersWithReservationsInDateRange(List<Reservation> reservations, LocalDate startDate, LocalDate endDate) {
        return reservations.stream()
                .filter(reservation -> !reservation.getStartDate().isBefore(startDate) && !reservation.getEndDate().isAfter(endDate))
                .map(Reservation::getCustomer)
                .collect(Collectors.toSet());
    }
}
