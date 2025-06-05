package ru.titov.axon.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.titov.axon.data.model.Renter;

import java.util.UUID;

@Repository
public interface RenterRepository extends JpaRepository<Renter, UUID> {
}
