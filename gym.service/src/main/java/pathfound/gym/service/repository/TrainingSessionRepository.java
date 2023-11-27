package pathfound.gym.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pathfound.gym.service.dto.CoachDay;
import pathfound.gym.service.model.Member;
import pathfound.gym.service.model.TrainingSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession, UUID> {
    Optional<TrainingSession> findById(UUID uuid);
    @Query(value = "select week_day FROM trainingsession t where coach_id=:coachId and member_id=:memberId", nativeQuery = true)
    List<CoachDay> getCoachDays(UUID coachId, UUID memberId);
    @Query(value = "select * FROM trainingsession t where coach_id=:coachId and week_day IN(:day1,:day2)", nativeQuery = true)
    List<TrainingSession> findByCoachIdAndWeekDays(UUID coachId, String day1, String day2);

    @Query(value = "SELECT count(*)  FROM TRAININGSESSION where week_day IN ('MON', 'FRI')", nativeQuery = true)
    int getUnbookedSessions();
}
