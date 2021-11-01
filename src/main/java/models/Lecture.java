package models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Lecture {

    private String name;
    private LocalTime startTime;
    private LocalTime finishTime;

    public Lecture() {
    }

    public Lecture(String name, LocalTime startTime, LocalTime finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public Lecture(String name, String startTime, String finishTime) {
        this.name = name;
        this.setStartTimeFromString(startTime);
        this.setFinishTimeFromString(finishTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTimeFromString(String startTime) {
        this.startTime = LocalTime.parse(startTime,DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTimeFromString(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime,DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                '}';
    }

    public boolean hasConflictIntervalTimeLectures(Lecture otherLecture){

        if(otherLecture.getFinishTime().isAfter(this.getStartTime())){
            return true;
        }

        return false;


    }
}
