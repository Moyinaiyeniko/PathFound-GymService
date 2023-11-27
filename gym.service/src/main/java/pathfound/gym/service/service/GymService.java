package pathfound.gym.service.service;

import pathfound.gym.service.dto.*;
import pathfound.gym.service.model.TrainingSession;

import java.util.List;
import java.util.UUID;

public interface GymService {

    public void createGym(GymRequest request);

    public void addNewCoach(CoachRequest request);

    public void addNewMember(MemberRequest request);

    public void bookSession(TrainingSessionRequest request);

    public TrainingSession fetchTrainingSession(UUID sessionId);

    public int getUnbookedSessions();

  List<TrainingSessionResponseDTO> getCoachSessions(UUID coachId, String weekDay1, String weekDay2);
}
