/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;

/**
 *
 * @author emanhussein
 */
public class Alphabetizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String output;
        if (args.length < 2){
            System.err.println("Usage: java alphabetizer.Alphabetizer <inputFile.txt> <outputFile.txt>");
            System.exit(0);
        }
        
        String inputFileName = args[0];
        String outputFileName = args[1];
        try {
//            BufferedReader buffReader = new BufferedReader(new FileReader("/Users/emanhussein/Desktop/NIS_sample.txt"));
//            BufferedWriter buffWriter = new BufferedWriter(new FileWriter("/Users/emanhussein/Desktop/alphabetizer_output.txt"));

            BufferedReader buffReader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputFileName));

            String line = buffReader.readLine();
            while (line != null) {
                output = alphabetizer(line);
                try {
                    buffWriter.write(output);
                    buffWriter.newLine();
                } //end of try block that writes to the output file
                catch (IOException e) {
                    System.err.format("IOException while writing the output: %s%n", e);
                }//end of catch block

                line = buffReader.readLine();
            }
            buffReader.close();
            buffWriter.close();
        } //end of try block that reads from the file
        catch (IOException e) {
            e.printStackTrace();
            System.err.format("IOException while reading the input: %s%n", e);
        }// end of catch block
    }// end of main method

    /**
     *
     * @param input String to be alphabetized
     * @return String after applying alphabetization
     */
    public static String alphabetizer(String input) {
        String output = "";
        HashMap<Character, Integer> uppercaseTracker = uppercaseTracker(input);

        // remove special characters & converting the string to lowercase
        input = input.replaceAll("\\s", "").replaceAll("[^a-zA-Z]", "");
        input = input.toLowerCase();
        // convert input string to char array
        char intermediateArray[] = input.toCharArray();
        // sort tempArray
        Arrays.sort(intermediateArray);
        // return new sorted string
        output = new String(intermediateArray);
        output = retrieveOriginal(output, uppercaseTracker);
        System.out.println(output);
        return output;
    }//end of main method

    /**
     *
     * @param input String to track the occurences of uppercase alphabets in
     * @return HashMap where the key is the uppercase alphabet and the value is
     * the number of times it occured in the input String
     */
    public static HashMap<Character, Integer> uppercaseTracker(String input) {
        HashMap<Character, Integer> uppercaseTracker = new HashMap<Character, Integer>();
        // scan the input string to track occurences of uppercase alphabets
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                if (uppercaseTracker.containsKey(currentChar)) {
                    int counter = uppercaseTracker.get(currentChar);
                    uppercaseTracker.put(currentChar, counter + 1);
                } else {
                    uppercaseTracker.put(currentChar, 1);
                }
            }//end of if condition checking for uppercase
        }//end of for loop scanning the string

        return uppercaseTracker;

    }

    /**
     *
     * @param input String to iterate over its characters to decide whether they
     * were originally uppercase or not by checking the HashMap passed as a
     * parameter
     * @param tracker
     * @return String with characters that was originally uppercase retrieved.
     * N.B. This approach is assuming that the order of uppercase and lowercase
     * doesn't matter ex.: Vv is the same as vV --> they both will be
     * alphabetized to Vv
     */
    public static String retrieveOriginal(String input, HashMap<Character, Integer> tracker) {
        String output = "";
        // convert input string to char array
        char intermediateArray[] = input.toCharArray();

        for (int i = 0; i < intermediateArray.length; i++) {
            if (!tracker.isEmpty()) { // if the hashmap is empty, no need to keep iterating over the string.
                char currentChar = intermediateArray[i];
              
                if (tracker.containsKey(Character.toUpperCase(currentChar))) {
                    int occurences = tracker.get(Character.toUpperCase(currentChar));
                    if (occurences - 1 > 0) {
                        tracker.put(currentChar, occurences - 1);

                    } else if (occurences - 1 == 0) {
                        tracker.remove(Character.toUpperCase(currentChar));
                    }

                    currentChar = Character.toUpperCase(currentChar);
                    intermediateArray[i] = currentChar;
                    
                } //end of if (tracker.containsKey(currentChar))
            }//edn of if condition checking if the hashmap is empty.
        }//end of for loop
        output = new String(intermediateArray);
        
        return output;

    }// end of retrieveOriginal method
}// end of class Alphabetizer

//Resources I referred to:
//Java Read File line by line using BufferedReader: https://www.journaldev.com/709/java-read-file-line-by-line 
// Writing to a file: https://www.javatpoint.com/java-bufferedwriter-class 
//Checking if a character is uppercase: https://www.tutorialspoint.com/java/character_isuppercase.htm
//remove special characters from string: https://www.javatpoint.com/how-to-remove-special-characters-from-string-in-java
//remove key from hashmap: https://www.geeksforgeeks.org/hashmap-remove-method-in-java/
//converting  string's characters to ther lowercase: https://www.w3schools.com/java/ref_string_tolowercase.asp
//sort string alphabetically: https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
// To compile from the command line: https://www.learnjavaonline.org/en/Compiling_and_Running_with_Arguments

