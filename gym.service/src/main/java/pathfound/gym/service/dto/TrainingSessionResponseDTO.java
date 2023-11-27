package pathfound.gym.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public record TrainingSessionResponseDTO(
        String gymName,
        CoachDay weekday,
        String coachName,
        String memberName
) {


}
