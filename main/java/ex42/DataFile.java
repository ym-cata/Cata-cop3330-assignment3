/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yesenia Cata
 */

package ex42;

import java.util.*; //imports java files
import java.io.*;

public class DataFile { //begins code with class

    public void printDetails(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file); //scans user input

            while (sc.hasNext()) { //while loop
                String s = sc.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }
    public static void main(String[] args) {

        DataFile emp = new DataFile();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary"); //prints out
        System.out.println("----------------------------------------");
        emp.printDetails("src/main/java/ex42/exercise42_input.txt"); //takes input file in order to output
    }
}

/*

 Import necessary classes for program

 public class DataFile {
    public void printDetails(String filename) {
        opens a file with "try"
        scans user input
        uses while loop
        prints out error in case the file is not found

    public static void main(String[] args) {
       input file in order to output
       takes info from text file to create table and list data

      }

    }

  */