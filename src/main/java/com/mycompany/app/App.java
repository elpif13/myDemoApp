package com.mycompany.app;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    /*It takes the given index range of the arrays, 
    converts the integer values ​​in this range into characters, 
    and checks whether the two strings are anagrams.*/
    
    public static boolean search(ArrayList<Integer> array,ArrayList<Integer> array2, int start, int end) {
        
        //-------edge cases------------
        if(array == null || array2 == null)
          return false;

        if(start>end || start<0)
          return false;

        int length = start - end + 1; // length of index
        if(array.size()<length || array2.size()<length)
          return false;

        if(end >= array.size() || end >= array2.size())  
          return false;

        //---------------------------

        String str1 = "",str2=""; // default

        // convert arrays to string
        for(int i=start; i<=end; i++){
            if(array.get(i)>=32 && array.get(i)<=126)
            str1 += (char)array[i];
            
            if(array2.get(i)>=32 && array2.get(i)<=126)
            str2 += (char)array2[i];
        }

        int[] charCount1 = new int[256];
        int[] charCount2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            charCount1[str1.charAt(i)]++;
            charCount2[str2.charAt(i)]++;
        }

        // check the freakans of chars
        for (int i = 32; i <= 126; i++) {
            if (charCount1[i] != charCount2[i]) {
                return false;
            }
        }

        return true;

    }
}
