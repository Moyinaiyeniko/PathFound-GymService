package pathfound.gym.service.mapper;

import pathfound.gym.service.dto.TrainingSessionResponseDTO;
import pathfound.gym.service.model.TrainingSession;

import java.util.function.Function;

public class TrainingSessionDTOMapper implements Function<TrainingSession, TrainingSessionResponseDTO> {
    @Override
    public TrainingSessionResponseDTO apply(TrainingSession trainingSession) {
        return new TrainingSessionResponseDTO(
                trainingSession.getGym().getName(),
                trainingSession.getWeekDay(),
                trainingSession.getCoach().getName(),
                trainingSession.getMember().getName()
        );
    }
}
