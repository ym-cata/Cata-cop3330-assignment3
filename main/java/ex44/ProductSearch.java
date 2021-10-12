
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Yesenia Cata
 */
package ex44;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ProductSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scans input
        int temp = 1;
        String userInput;
        JSONParser parser = new JSONParser(); //uses JSON parser
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> quant = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();

        try {
            Object fr = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
            JSONObject input = (JSONObject)fr; //Create another json
            JSONArray products = (JSONArray)input.get("products");

            for (int i = 0; i < products.size(); i++) {
                String data = String.valueOf(products.get(i));
                String[] array = data.split(",");
                names.add(array[2]);
                price.add(array[1]);
                quant.add(array[0]);
            }

            while (temp == 1) {
                System.out.println("What is the product name?"); //asks user to input product name
                userInput = sc.nextLine();

                if (productInfo.check(names, userInput) != -1) {
                    int index = productInfo.check(names, userInput);
                    System.out.println("Name: " + names.get(index).substring(names.get(index).indexOf(userInput), names.get(index).length() - 2));
                    System.out.println("Price: " + price.get(index).substring(8, price.get(index).length()));
                    System.out.println("Quantity: " + quant.get(index).substring(12, quant.get(index).length()));
                    temp = 0;
                }

                if (temp == 1) //If flag value is zero, then value is not found
                    System.out.println("Sorry, that product was not found in our inventory.");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }
}
