package ru.titov.axon.data.input.renter;

import lombok.Value;

@Value
public class CreateRenterInput {
    String name;
    String lastName;
    int age;
}
