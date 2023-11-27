package pathfound.gym.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pathfound.gym.service.model.Gym;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface GymRepository extends JpaRepository<Gym, UUID> {

    Optional<Gym> findById(UUID uuid);
}
