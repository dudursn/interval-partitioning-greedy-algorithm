import models.Classroom;
import models.Lecture;
import utils.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class GreedyAlgorithm {

    private Integer classNumber;
    private List<Classroom> classrooms;

    public GreedyAlgorithm() {
        //Total class allocated
        this.classNumber = 0;
        //Class allocated
        this.classrooms = new ArrayList<>();
    }


    public void run(List<Lecture> lectures) {

        //Total of lectures
        int n = lectures.size();

        //Sort by Starting time so that s1 < s2 < s3 < s4 < ... < sn and saving on the MinHeapy
        MinHeap heap = new MinHeap(n);
        heap.createHeap(lectures);

        for (int i = 0; i < n; i++) {

            //Get min lecture by starting time and remove to the MinHeap
            Lecture current = heap.remove();

            //Class empty => add lecture
            if (this.classrooms.isEmpty()) {

                addLectureToNewClassroom(current);
            }else{

                checkAndAddLectureToClassroom(current);
            }

        }

    }

    private void checkAndAddLectureToClassroom(Lecture current){

        boolean compatibleStatus = false;

        for (Classroom aux : this.classrooms){
            //Get last lecture add in class to compare with current
            Lecture last = aux.getLectures().get(aux.getLectures().size()-1);
            if(!current.hasConflictIntervalTimeLectures(last)){
                aux.addLectures(current);
                compatibleStatus = true;
                break;
            }
        }

        if(!compatibleStatus){
            addLectureToNewClassroom(current);
        }

    }

    private void addLectureToNewClassroom(Lecture lecture){
        Classroom d = new Classroom("class "+ String.valueOf(this.classNumber));
        d.getLectures().add(lecture);
        this.classNumber++;
        this.classrooms.add(d);
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public void printResult() {
        for (Classroom c : this.classrooms){
            System.out.println(c);
        }
    }
}
