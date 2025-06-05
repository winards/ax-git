package ru.titov.axon.cqrs.renter.event;

import lombok.Value;

import java.util.UUID;

@Value
public class RenterDeletedEvent {
    UUID id;
}
