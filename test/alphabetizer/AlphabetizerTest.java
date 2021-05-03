/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabetizer;

import java.io.File;
import java.io.IOException;
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
     * Test of alphabetizer method, of class Alphabetizer.
     */
    @Test
    public void testAlphabetizerEmptyStrings() {
        System.out.println("alphabetizer");
        String input = "";
        String expResult = "";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlphabetizerSample() {
        System.out.println("alphabetizer");
        String input = "VirginiaTech";
        String expResult = "aceghiiinrTV";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlphabetizerNumeric() {
        System.out.println("alphabetizer");
        String input = "3 Blind Mice";
        String expResult = "BcdeiilMn";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlphabetizerRepeatition() {
        System.out.println("alphabetizer");
        String input = "Vvv";
        String expResult = "Vvv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlphabetizerRepeatitionUpperLowerCase() {
        System.out.println("alphabetizer");
        String input = "Vv";
        String expResult = "Vv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    @Test
    public void testAlphabetizerRepeatitionLowerUpperCase() {
        System.out.println("alphabetizer");
        String input = "vV";
        String expResult = "Vv";
        String result = Alphabetizer.alphabetizer(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of uppercaseTracker method, of class Alphabetizer.
     */
    @Test
    public void testUppercaseTracker() {
        System.out.println("uppercaseTracker");
        String input = "VirginiaTech";
        HashMap<Character, Integer> expResult = new HashMap<>();
        expResult.put('V', 1);
        expResult.put('T', 1);
        HashMap<Character, Integer> result = Alphabetizer.uppercaseTracker(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of retrieveOriginal method, of class Alphabetizer.
     */
    @Test
    public void testRetrieveOriginalEmpty() {
        System.out.println("retrieveOriginal");
        String input = "";
        HashMap<Character, Integer> tracker = new HashMap<>();
        String expResult = "";
        String result = Alphabetizer.retrieveOriginal(input, tracker);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetrieveOriginal() {
        System.out.println("retrieveOriginal");
        String sortedInput = "aceghiiinrtv"; //initial input is "VirginiaTech"
        HashMap<Character, Integer> tracker = new HashMap<>();
        tracker.put('V', 1);
        tracker.put('T', 1);
        String expResult = "aceghiiinrTV";
        String result = Alphabetizer.retrieveOriginal(sortedInput, tracker);
        assertEquals(expResult, result);
    }
}
