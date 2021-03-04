package sections.five.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Bruno","Fernandes");

        //then
        assertAll("Test props set",
                () -> assertEquals("Bruno",person.getFirstName()),
                () -> assertEquals("Fernandes", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1l, "Bruno", "Fernandes");

        //then
        assertAll("Test props set",
                () -> assertEquals("Bruno",person.getFirstName(),"First name wrong"),
                ()-> assertEquals("Fernandes", person.getLastName(),"Lastname wrong"));
    }
}