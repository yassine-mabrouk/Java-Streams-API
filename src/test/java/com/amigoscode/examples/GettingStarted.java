package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> result = new ArrayList<>();

        int c=0;
        for (Person p: people
        ) {
            if(p.getAge()  < 18 ){
                result.add(p);
                c++;
                if (c >10 ) break;
            }
        }
        result.forEach(System.out::println);
    }


    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> result = new ArrayList<>();
        result=  people.stream().filter(p -> p.getAge() < 5).limit(3).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
