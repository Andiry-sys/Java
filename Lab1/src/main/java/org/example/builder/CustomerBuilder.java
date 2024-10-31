package org.example.builder;

import org.example.Models.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerBuilder {
    private String lastName;
    private String firstName;
    private String documentType;
    private LocalDate birthDate;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]+$");
    private static final Pattern DOCUMENT_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1900, 1, 1);

    public CustomerBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder documentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public CustomerBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Customer build() {
        List<String> validationErrors = validateFields();
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid field values:\n" + String.join("\n", validationErrors));
        }
        return new Customer(lastName, firstName, documentType, birthDate);
    }

    private List<String> validateFields() {
        List<String> errors = new ArrayList<>();

        if (lastName == null || !NAME_PATTERN.matcher(lastName).matches()) {
            errors.add("lastName: '" + lastName + "' - must contain only letters and not be empty.");
        }

        if (firstName == null || !NAME_PATTERN.matcher(firstName).matches()) {
            errors.add("firstName: '" + firstName + "' - must contain only letters and not be empty.");
        }

        if (documentType == null || !DOCUMENT_PATTERN.matcher(documentType).matches()) {
            errors.add("documentType: '" + documentType + "' - must contain only letters and numbers.");
        }

        if (birthDate == null || birthDate.isAfter(LocalDate.now()) || birthDate.isBefore(MIN_BIRTH_DATE)) {
            errors.add("birthDate: '" + birthDate + "' - must be between " + MIN_BIRTH_DATE + " and today.");
        }

        return errors;
    }
}
