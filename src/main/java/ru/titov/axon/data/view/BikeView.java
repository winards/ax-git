package ru.titov.axon.data.view;

import lombok.Value;
import ru.titov.axon.data.model.types.BikeColor;

import java.time.Instant;
import java.util.UUID;

@Value
public class BikeView {

    UUID id;
    UUID renterId;
    String name;
    String description;
    Instant createdAt;
    boolean rented;
    double mileage;
    BikeColor color;

}
