package ru.titov.axon.data.input.bike;

import lombok.Value;

import java.util.UUID;

@Value
public class RentBikeInput {
    UUID bikeId;
    UUID renterId;
}
