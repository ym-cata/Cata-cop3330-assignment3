/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yesenia Cata
 */
package ex43;

import java.io.*;
import java.util.Scanner;

public class Generator {
    public static void main(String[] args)
    {
        Scanner SC = new Scanner(System.in); //scans user input
        String currentPath, author, siteName;
        char js = 'N';
        char css = 'N';
        System.out.print("Site name: "); //asks user the site name
        siteName = SC.nextLine();
        System.out.print("Author: "); //ask user the author
        author = SC.nextLine();
        System.out.print("Do you want a folder for JavaScript? "); //ask user a yes or no question
        js = SC.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = SC.next().charAt(0);
        currentPath = System.getProperty("user.dir");
        currentPath += "\\"+siteName;
        File website = new File(currentPath);
        boolean websiteCreated = website.mkdir();
        if(websiteCreated)
        {
            System.out.println("Created " + currentPath);
            try
            {
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+"\\index.html")); //creates new file
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();
                System.out.println("Created " + currentPath+"\\index.html");
                if(js == 'y' || js == 'Y') //uses if else statement based on user input
                {
                    File jsFolder = new File(currentPath+"\\js");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        System.out.println("Created " + jsFolder+"\\");
                    }
                    else
                    {
                        System.out.println("Js folder not created!!");
                    }
                }
                if(css == 'y' || css == 'Y') //uses if else statement based on users input
                {
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();
                    if(cssCreated)
                    {
                        System.out.println("Created " + cssFolder+"\\");
                    }
                    else
                    {
                        System.out.println("CSS folder not created!!");
                    }
                }
            }
            catch(IOException e) //in case what user inputted is not able to be found
            {
                System.out.println("index.html not created as required!!"); //prints error message
            }
        }
        else
        {
            System.out.println("Website folder not created!!");
        }
        SC.close();
    }
}

/*

 Import necessary classes for program

 public class Generator {
    public static void main(String[] args) {
        scans user input
        asks user questions in order for program to run
        use if else if statement to determine what will print out
        create error messages

    }

  */

