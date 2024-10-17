/**
 * Represents a customer making a reservation.
 */
public class Customer {
    private String lastName;
    private String firstName;
    private String documentId;
    private LocalDate birthDate;

    public Customer(String lastName, String firstName, String documentId, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentId = documentId;
        this.birthDate = birthDate;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", documentId='" + documentId + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return lastName.equals(customer.lastName) &&
                firstName.equals(customer.firstName) &&
                documentId.equals(customer.documentId) &&
                birthDate.equals(customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, documentId, birthDate);
    }
}
