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
    concatinates the two strings and returns.*/
    
    public static String search(ArrayList<Integer> array,ArrayList<Integer> array2, int start, int end) {
        
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

        
        return str1+str2;
        

    }
}
