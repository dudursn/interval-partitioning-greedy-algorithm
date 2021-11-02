import models.Classroom;
import models.Lecture;
import utils.MinHeap;
import utils.ReadCSV;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {

    public static void main(String [] args){
        System.out.println("Teste");
        String fileName = System.getProperty("user.dir")+"\\data\\lectures.csv";
        System.out.println("Working Directory = " + fileName);


        List<String[]> content = ReadCSV.read(fileName);
        List<Lecture> lectures = new ArrayList<>();
        for (String[] c: content){
            String[] strings = Arrays.stream(c).toArray(String[]::new);
            lectures.add(new Lecture(strings[0], strings[1], strings[2]));
        }

        GreedyAlgorithm G = new GreedyAlgorithm();
        G.run(lectures);
        G.printResult();
    }
}
