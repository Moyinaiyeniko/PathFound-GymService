package pathfound.gym.service.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pathfound.gym.service.client.dto.TrainingSession;

@Service
public class TrainingSessionImpl {

    RestTemplate restTemplate = new RestTemplate();

    public  TrainingSession[] getSessions(){
       TrainingSession[]  responseEntity = restTemplate.getForObject("http://localhost:9095/v1/session/6ce0f94a-92d1-4b61-a92d-10c2c89a165c/SAT/FRI", TrainingSession[].class);
   return  responseEntity;
    }


}
