package pathfound.gym.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pathfound.gym.service.model.Gym;
import pathfound.gym.service.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {

    Optional<Member> findById(UUID uuid);
}
