package com.cachelld;

import com.cachelld.commands.CommandFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        File input = new File("/Users/mmt8311/Personal/java/cachelld/src/com/cachelld/input.txt");
        CommandFactory commandFactory = CommandFactory.getInstance();

        try {
            Scanner sc = new Scanner(input);
            while(sc.hasNextLine()){
                System.out.print("->");
                String[] cmd = sc.nextLine().split(" ");
                commandFactory.executeCommand(cmd);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
