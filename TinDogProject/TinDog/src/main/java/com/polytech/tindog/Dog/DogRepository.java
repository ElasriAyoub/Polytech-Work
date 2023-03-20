package com.polytech.tindog.Dog;

import com.polytech.tindog.Owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DogRepository extends JpaRepository<Dog, UUID> {
    Optional<Dog> findById(UUID id);
    Optional<Dog> findByOwnerId(String ownerId);
}
