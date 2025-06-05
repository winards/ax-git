package ru.titov.axon.data.input.bike;

import lombok.Value;
import ru.titov.axon.data.model.types.BikeColor;

import java.util.UUID;

@Value
public class UpdateBikeInput {
    UUID bikeId;
    String name;
    String description;
    BikeColor color;
}
