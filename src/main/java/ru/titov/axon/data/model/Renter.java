package ru.titov.axon.data.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Renter {

    @Id
    private UUID id;
    private String name;
    private String lastName;
    private int age;

}
