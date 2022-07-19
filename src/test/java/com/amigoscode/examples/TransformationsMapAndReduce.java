package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.*;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> mappingPeaple = people.stream()
                .map(person -> {
                    return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
                })
                .limit(10)
                .collect(Collectors.toList());
        assertThat(10).isEqualTo(mappingPeaple.size());
        mappingPeaple.forEach(System.out::println);

        // using function
        System.out.println("Üsing function ");
        List<PersonDTO> mappingPeapleUsingFunction  = people.stream()
                .map(PersonDTO::map)
                .limit(5)
                .collect(Collectors.toList());
        mappingPeaple.forEach(System.out::println);
        List<String> mappingPeapleString = people.stream()
                .map(person ->
                     new String(person.getFirstName())
                )
                .limit(10)
                .collect(Collectors.toList());
        assertThat(10).isEqualTo(mappingPeaple.size());
        mappingPeapleString.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

