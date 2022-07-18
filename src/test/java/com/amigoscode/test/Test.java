package com.amigoscode.test;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        List<Person> list = MockData.getPeople();
        List<Person> result = new ArrayList<>();

        int c=0;
        System.out.println("================= impirative   programing ===============");
        for (Person p: list
             ) {
            if(p.getAge()  < 5 ){
                result.add(p);
                c++;
                if (c >10 ) break;
            }
        }
        result.forEach(System.out::println);
        System.out.println("================= Declarative programing ===============");
      result=  list.stream().filter(p -> p.getAge() < 5).limit(3).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
