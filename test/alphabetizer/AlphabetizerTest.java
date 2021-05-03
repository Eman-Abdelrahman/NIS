/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetizer;

import java.io.File;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emanhussein
 */
public class AlphabetizerTest {

    
    /**
     * Test of main method, of class Alphabetizer.
     */
    @Test
    public void testMainNullArgs() {
        System.out.println("main: passing no arguments");
        String[] args = null;
        Alphabetizer.main(args);
        fail("Usage: java alphabetizer.Alphabetizer <inputFile.txt> <outputFile.txt>");
        //        Alphabetizer.main(args);
    }

    @Test
    public void testMainMissingArg() {
        System.out.println("main: passing only one argument");
        String[] args = {"NIS_sample.txt"};
        if (args.length < 2) {
            fail("Two filenames should be passed as arguments: First is Input file name and second is output file name");
        }
        //        Alphabetizer.main(args);
    }

    @Test
    public void testMainTwoArgsInvalidInputFile() {
        System.out.println("main: passing two arguments but input file doesn't exist");
        String[] args = {"NIS_sample.txt", "alphabetizer_output.txt"};
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            fail("Input File doesn't exist");
        }
        //        Alphabetizer.main(args);
    }

    @Test
    public void testMainTwoValidArgs() {
        System.out.println("main: passing two valid arguments");
        String[] args = {"NIS_sample.txt", "alphabetizer_output.txt"};
        Alphabetizer.main(args);
    }

    /**
     * Test of alphabetizer method, of class Alphabetizer.
     */
    @Test
    public void testAlphabetizerEmptyStrings() {
        System.out.println("alphabetizer");
        String input = "";
        String expResult = "";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    @Test
    public void testAlphabetizerSample() {
        System.out.println("alphabetizer");
        String input = "VirginiaTech";
        String expResult = "aceghiiinrTV";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    @Test
    public void testAlphabetizerNumeric() {
        System.out.println("alphabetizer");
        String input = "3 Blind Mice";
        String expResult = "BcdeiilMn";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    @Test
    public void testAlphabetizerRepeatition() {
        System.out.println("alphabetizer");
        String input = "Vvv";
        String expResult = "Vvv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    @Test
    public void testAlphabetizerRepeatitionUpperLowerCase() {
        System.out.println("alphabetizer");
        String input = "Vv";
        String expResult = "Vv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    @Test
    public void testAlphabetizerRepeatitionLowerUpperCase() {
        System.out.println("alphabetizer");
        String input = "vV";
        String expResult = "Vv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
        fail("Output is incorrect");
    }

    /**
     * Test of uppercaseTracker method, of class Alphabetizer.
     */
    @Test
    public void testUppercaseTracker() {
        System.out.println("uppercaseTracker");
        String input = "VirginiaTech";
        HashMap<Character, Integer> expResult = new HashMap<Character, Integer>();
        expResult.put('V', 1);
        HashMap<Character, Integer> result = Alphabetizer.uppercaseTracker(input);
        assertEquals(expResult, result);
        fail("UpperCase Tracker content is incorrect. The keys are case-sensitive and the values should indicate the occurences of each key");
    }

    /**
     * Test of retrieveOriginal method, of class Alphabetizer.
     */
    @Test
    public void testRetrieveOriginalEmpty() {
        System.out.println("retrieveOriginal");
        String input = "";
        HashMap<Character, Integer> tracker = new HashMap<Character, Integer>();
        String expResult = "";
        String result = Alphabetizer.retrieveOriginal(input, tracker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testRetrieveOriginal() {
        System.out.println("retrieveOriginal");
        String input = "aceghiiinrtv";
        HashMap<Character, Integer> tracker = new HashMap<Character, Integer>();
        tracker.put('V',1);
        tracker.put('T', 1);
        String expResult = "aceghiiinrTV";
        String result = Alphabetizer.retrieveOriginal(input, tracker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Orginia letter cases couldn't be retrieved");
    }

}
