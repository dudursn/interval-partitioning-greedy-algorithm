package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.w3c.dom.css.CSSValue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCSV {

    public static List<String[]> read(String fileName) {
        List<String[]> r = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            r = reader.readAll();
        }catch (FileNotFoundException | CsvException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return r;
    }
}
