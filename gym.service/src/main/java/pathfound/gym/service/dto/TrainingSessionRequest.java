package pathfound.gym.service.dto;

import java.util.UUID;

public record TrainingSessionRequest(
        UUID gymId,
        UUID memberId,
        UUID coachId,
        CoachDay trainingDay
) {
}
