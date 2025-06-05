package ru.titov.axon.cqrs.renter.event;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Value
public class RenterUpdatedEvent {
    UUID id;
    String name;
    String lastName;
    int age;
}
