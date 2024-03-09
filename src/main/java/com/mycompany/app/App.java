package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App
{
    /*It takes the given index range of the arrays,
    converts the integer values ​​in this range into characters,
    concatinates the two strings and returns.*/

     public static String search(ArrayList<Integer> array, ArrayList<Integer> array2, int start, int end) {

        //-------edge cases------------
        if(array == null || array2 == null)
            return null;

        if(start>end || start<0)
            return null;

        int length = start - end + 1; // length of index
        if(array.size()<length || array2.size()<length)
            return null;

        if(end >= array.size() || end >= array2.size())
            return null;

        //---------------------------

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();


        // convert arrays to string
        for(int i=start; i<=end; i++){
            if(array.get(i)>=32 && array.get(i)<=126)
                str1.append((char) (int)array.get(i));

            if(array2.get(i)>=32 && array2.get(i)<=126)
                str2.append((char) (int)array2.get(i));
        }


        return str1.toString()+str2.toString();


    }

   public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);

          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);


          String startStr = req.queryParams("start").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(startStr);

          String endStr = req.queryParams("end").replaceAll("\\s","");
          int input2AsInt2 = Integer.parseInt(endStr);

          String result = App.search(inputList, inputList2,input2AsInt,input2AsInt2);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}