package com.example.geektrust;

import com.example.geektrust.fileinput.ReadFile;
import com.example.geektrust.util.PrintDetailsUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String pathToFile = args[0];
        ReadFile fileReaderInstance = new ReadFile();
        List<String> instructionList = fileReaderInstance.readFile(pathToFile);

        PrintDetailsUtil printDetailsUtil = new PrintDetailsUtil();
        printDetailsUtil.buildSolution(instructionList);
    }
}
