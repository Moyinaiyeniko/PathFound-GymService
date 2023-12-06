package pathfound.gym.service.client.dto;

public class TrainingSession {

   private String gymName;
    private String weekday;
    private String coachName;
    private String memberName;

    public TrainingSession() {
    }

    public TrainingSession(String gymName, String weekday, String coachName, String memberName) {
        this.gymName = gymName;
        this.weekday = weekday;
        this.coachName = coachName;
        this.memberName = memberName;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
