package pathfound.gym.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pathfound.gym.service.dto.*;
import pathfound.gym.service.model.TrainingSession;
import pathfound.gym.service.service.GymServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class GymController {

    private final GymServiceImpl impl;

    @PostMapping("/newgym")
     public void createNewGym(@RequestBody GymRequest request){
         impl.createGym(request);
     }
    @PostMapping("/newcoach")

    public void addNewCoach(@RequestBody CoachRequest request){
        impl.addNewCoach(request);
    }
    @PostMapping("/newmember")
    public void addNewMember(@RequestBody MemberRequest request){
        impl.addNewMember(request);
    }
    @PostMapping("/booksession")
    public void bookNewSession(@RequestBody TrainingSessionRequest request){
         impl.bookSession(request);
    }

    @GetMapping(value = "/session/{sessionId}")
    public TrainingSession fetchTrainingSession(@PathVariable UUID sessionId){
        return impl.fetchTrainingSession(sessionId);
    }

    @GetMapping(value = "/session/{coachId}/{weekDay1}/{weekDay2}")
    public List<TrainingSessionResponseDTO> getCoachSessions(@PathVariable UUID coachId, @PathVariable String weekDay1, @PathVariable String weekDay2){
        return impl.getCoachSessions(coachId,weekDay1,weekDay2);
    }

    @GetMapping(value = "/unbookedsessions")
    public int getUnbookedSessions(){
        return impl.getUnbookedSessions();
    }
}
