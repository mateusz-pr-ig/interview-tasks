package com.jmatt.interview.task1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterviewTest {

    private Interview interview = new Interview();

    @Test
    public void getFullNameTest() {
        String fullName = interview.getFullName(new Person("John", "Smith", 12));
        assertEquals(fullName, "John Smith");
    }

    @Test
    public void shouldThrowInvalidArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> interview.getFullName(null));
    }

    @Test
    public void countWordsInString() {
        long count = interview.countWordsStartsWithA("Aasdas Basdas Aasdasd Dasdas Easdasdas Aasdasd");
        assertEquals(count, 3L);
    }

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", "Johnson", 4);
        Person viktor = new Person("Viktor", "Ravi", 40);
        Person eva = new Person("Eva", "Minge",42);
        List<Person> collection = asList(sara, eva, viktor);
        assertEquals(interview.getOldestPerson(collection), eva);
    }

    @Test
    public void shouldGetOnlyKidNames() {
        Person sara = new Person("Sara", "Johnson",4);
        Person viktor = new Person("Viktor", "Ravi", 40);
        Person eva = new Person("Eva", "Minge", 42);
        Person anna = new Person("Anna", "Frankson", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(interview.getKidNames(collection), hasItems("Sara", "Anna"));
        assertThat(interview.getKidNames(collection), not(hasItems("Viktor", "Eva")));
    }

    @Test
    public void shouldSeparateBySecondName() {
        Person sara = new Person("Sara", "Ravi", 4);
        Person viktor = new Person("Viktor", "Ravi", 40);
        Person eva = new Person("Eva", "Minge",42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<Person>> result = interview.separateBySecondName(collection);
        assertThat(result.get("Ravi"), hasItems(sara, viktor));
        assertThat(result.get("Minge"), hasItem(eva));
    }
}
