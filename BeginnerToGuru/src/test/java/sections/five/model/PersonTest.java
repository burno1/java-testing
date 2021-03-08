package sections.five.model;

import org.junit.jupiter.api.*;
import sections.petclinic.model.Person;
import sections.six.ModelTests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @DisplayName("Grouped Aassertions")
    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Bruno","Fernandes");

        //then
        assertAll("Test props set",
                () -> assertEquals("Bruno",person.getFirstName()),
                () -> assertEquals("Fernandes", person.getLastName()));
    }

    @DisplayName("Grouped Assertions with message")
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