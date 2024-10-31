package org.example.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a customer making a reservation.
 */
public class Customer {
    private String lastName;
    private String firstName;
    private String idDocument;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Customer() {
    }

    public Customer(  String lastName,
                      String firstName,
                     String documentId,
                      LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDocument = documentId;
        this.birthDate = birthDate;
    }



    // Getters

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return lastName.equals(customer.lastName) &&
                firstName.equals(customer.firstName) &&
                idDocument.equals(customer.idDocument) &&
                birthDate.equals(customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, idDocument, birthDate);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", documentId='" + idDocument + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
