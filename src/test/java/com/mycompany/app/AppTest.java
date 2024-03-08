package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    //Check if the method returns null when array is null
    public void testArrayIsNull() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = null;
      assertEquals(null,new App().search(array, null,0,3));
    }

    //Check if the method returns null when start>end
    public void testStartIsGreaterThanEnd() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
      assertEquals(null,new App().search(array, array2,3,2));
    }

    //Check if the method returns null when start<0
    public void testStartIsLessThanZero() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
      assertEquals(null,new App().search(array, array2,-1,2));
    }

    //Check if the start and end are in right range, returns null
    public void testStartAndEndRange() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
      assertEquals(null,new App().search(array, array2,0,4));
    }

    //Check if the method returns null when end is greater than Size of list
    public void testEndIsGreaterThanSize() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
      assertEquals(null,new App().search(array, array2,2,6));
    }


    public void testCorrectResult() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(65,66,67));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(97,98,99));
      assertEquals("ABCabc",new App().search(array, array2,0,2));
    }

    

}
