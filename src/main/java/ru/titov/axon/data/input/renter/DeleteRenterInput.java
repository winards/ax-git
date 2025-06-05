package ru.titov.axon.data.input.renter;

import lombok.Value;

import java.util.UUID;

@Value
public class DeleteRenterInput {
    UUID id;
}
