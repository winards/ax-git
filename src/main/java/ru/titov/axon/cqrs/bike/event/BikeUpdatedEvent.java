package ru.titov.axon.cqrs.bike.event;

import lombok.Value;
import org.axonframework.serialization.Revision;
import ru.titov.axon.data.model.types.BikeColor;

import java.util.UUID;

@Value
@Revision("1.1")
public class BikeUpdatedEvent {
    UUID id;
    String name;
    String description;
    BikeColor bikeColor;
}
