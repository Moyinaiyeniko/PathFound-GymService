package pathfound.gym.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pathfound.gym.service.model.Coach;
import pathfound.gym.service.model.Gym;

import java.util.Optional;
import java.util.UUID;

public interface CoachRepository extends JpaRepository<Coach, UUID> {

    Optional<Coach> findById(UUID uuid);
}
