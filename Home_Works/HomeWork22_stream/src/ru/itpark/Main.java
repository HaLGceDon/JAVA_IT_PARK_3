package ru.itpark;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader;
        String fileName = "input.txt";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File \"" + fileName + "\" not found");
        }
        List<String> listInput = new ArrayList<>();

        String temp;
        try {
            while ((temp = bufferedReader.readLine()) != null)
                listInput.add(temp);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }




      int ageCount[] = new int[100];

        listInput.stream()
               .map(string -> {
                   int tempAge = 0;
                   int count = 1;
                   for (int i = string.length() - 1; i > 0; i--) {
                       if (string.charAt(i) <= '9' & string.charAt(i) >= '0') {
                           tempAge +=  (string.charAt(i) - '0') * count;
                           count = count * 10;
                       }

                   }
                   return tempAge;

               })
                .forEach(integer -> ageCount[integer] += 1);

               // .forEach(System.out::println);



        for (int i = 0; i < 100; i++) {
            System.out.println( ageCount[i] + " - в возрасте " + i);
        }





    }

}

