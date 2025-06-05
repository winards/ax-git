package ru.titov.axon.data.input.bike;

import lombok.Value;

import java.util.UUID;

@Value
public class DeleteBikeInput {
    UUID bikeId;
}
