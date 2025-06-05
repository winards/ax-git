package ru.titov.axon.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.titov.axon.data.model.Bike;

import java.util.UUID;

@Repository
public interface BikeRepository extends JpaRepository<Bike, UUID> {
}
