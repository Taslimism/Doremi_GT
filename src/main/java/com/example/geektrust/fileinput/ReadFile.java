package com.example.geektrust.fileinput;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public List<String> readFile(String pathToFile) {
        try {
            List<String> instructionsList = new ArrayList<>();
            FileInputStream fis = new FileInputStream(pathToFile);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                instructionsList.add(sc.nextLine());
            }
            sc.close();
            return instructionsList;
        } catch (IOException ignored) {
        }

        return null;
    }
}
