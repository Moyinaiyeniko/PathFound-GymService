package pathfound.gym.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pathfound.gym.service.dto.*;
import pathfound.gym.service.exception.NotFoundException;
import pathfound.gym.service.mapper.TrainingSessionDTOMapper;
import pathfound.gym.service.model.Coach;
import pathfound.gym.service.model.Gym;
import pathfound.gym.service.model.Member;
import pathfound.gym.service.model.TrainingSession;
import pathfound.gym.service.repository.CoachRepository;
import pathfound.gym.service.repository.GymRepository;
import pathfound.gym.service.repository.MemberRepository;
import pathfound.gym.service.repository.TrainingSessionRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService{

    private final GymRepository gymRepository;
    private final CoachRepository coachRepository;
    private final MemberRepository memberRepository;
    private final TrainingSessionRepository trainingSessionRepository;
    TrainingSessionDTOMapper mapper = new TrainingSessionDTOMapper();
    @Override
    public void createGym(GymRequest request) {
        Gym newGym = new Gym();
        newGym.setName(request.name());
        gymRepository.save(newGym);
    }

    @Override
    public void addNewCoach(CoachRequest request) {
        Coach coach = new Coach();
        coach.setName(request.name());
        coachRepository.save(coach);
    }

    @Override
    public void addNewMember(MemberRequest request) {
        Member member = new Member();
        member.setName(request.name());
        memberRepository.save(member);
    }

    @Override
    public void bookSession(TrainingSessionRequest request) {

        Gym gym =gymRepository.findById(request.gymId()).orElseThrow(() -> new NotFoundException("Gym does not exist"));
        Member member = memberRepository.findById(request.memberId()).orElseThrow(() -> new NotFoundException("Member does not exist"));
        Coach coach = coachRepository.findById(request.coachId()).orElseThrow(() -> new NotFoundException("Coach does not exist"));
        List<CoachDay> existingCoachDays = Optional.of(trainingSessionRepository.getCoachDays(coach.getId(), member.getId())).orElseThrow(() -> new NotFoundException("No session booked for these days"));
       if(existingCoachDays.size()>2){
        throw new IllegalStateException("Coach days per week has been exceeded");
       }
        TrainingSession trainingSession = new TrainingSession();
        trainingSession.setGym(gym);
        trainingSession.setCoach(coach);
        trainingSession.setMember(member);
        trainingSession.setWeekDay(request.trainingDay());
         trainingSessionRepository.save(trainingSession);
    }


    @Override
    public TrainingSession fetchTrainingSession(UUID sessionId) {
        return trainingSessionRepository.findById(sessionId).orElseThrow(() -> new NotFoundException("Session does not exist"));
    }

    @Override
    @Cacheable("sessions")
    public int getUnbookedSessions(){
        return trainingSessionRepository.getUnbookedSessions();
    }

    @Override
    public List<TrainingSessionResponseDTO> getCoachSessions(UUID coachId, String weekDay1, String weekDay2) {
        return trainingSessionRepository.findByCoachIdAndWeekDays(coachId,weekDay1,weekDay2)
            .stream().map(mapper).collect(Collectors.toList());

    }


}
