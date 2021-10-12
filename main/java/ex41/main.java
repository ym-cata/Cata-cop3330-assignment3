/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yesenia Cata
 */

package ex41;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class main { //begin program with main class
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/java/ex41/exercise41_input.txt"); //inputs text file
        ArrayList<String> listNames = new ArrayList<>();
        NameSorter l = new NameSorter();
        Scanner sc = new Scanner(inputFile);

        while (sc.hasNextLine()) { //uses while loop to scan each name
            String data = sc.nextLine();
            listNames.add(data);
        }

        listNames = l.sort(listNames); //sorts the names

        System.out.println("Total of " + listNames.size() + " names\n----------------------");
        //Prints out total names and lists them in a table

        for (int i = 0; i < listNames.size(); i++) {
            System.out.println(listNames.get(i));
        }

        sc.close();

    }
}
 /*

 Import necessary classes for program

 public class main {
    public static void main(String[] args) throws IOException {
        inputs text file
        uses an array to list names
        uses class name
        scans user input using scanner
        uses while loop to scan each name
        uses listNames to sort names
        Prints total number of names and lists them
    }

  */