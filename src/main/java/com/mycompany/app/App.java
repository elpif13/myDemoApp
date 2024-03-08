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

    public static String search(int[] array,int[] array2, int start, int end) {

        //-------edge cases------------
        if(array == null || array2 == null)
            return null;

        if(start>end || start<0)
            return null;

        int length = start - end + 1; // length of index
        if(array.length<length || array2.length<length)
            return null;

        if(end >= array.length || end >= array2.length)
            return null;

        //---------------------------

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();


        // convert arrays to string
        for(int i=start; i<=end; i++){
            if(array[i]>=32 && array[i]<=126)
                str1.append((char) array[i]);

            if(array2[i]>=32 && array2[i]<=126)
                str2.append((char) array2[i]);
        }


        return str1.toString()+str2.toString();


    }
}