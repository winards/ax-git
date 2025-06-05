package ru.titov.axon.data.input.bike;

import lombok.Value;

@Value
public class BikeCreateInput {
    String name;
    String description;
}
