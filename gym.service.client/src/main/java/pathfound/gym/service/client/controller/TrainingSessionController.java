package pathfound.gym.service.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pathfound.gym.service.client.dto.TrainingSession;
import pathfound.gym.service.client.service.TrainingSessionImpl;

@RestController
public class TrainingSessionController {

    private final TrainingSessionImpl impl;


    public TrainingSessionController(TrainingSessionImpl impl) {
        this.impl = impl;
    }



    @GetMapping({"/trainingsession", "/"})
    public ModelAndView getAllTrainingSessions() {
        ModelAndView mav = new ModelAndView("gymsessions");
        mav.addObject("gymsessions", impl.getSessions());
        return mav;
    }


}
