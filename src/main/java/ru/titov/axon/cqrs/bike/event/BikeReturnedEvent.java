package ru.titov.axon.cqrs.bike.event;

import lombok.Value;

import java.util.UUID;

@Value
public class BikeReturnedEvent {
    UUID id;
    double mileageRidden;
}
