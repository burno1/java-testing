package sections.five.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {
    @Test
    void dependentAssertion() {
        Owner owner = new Owner(1l, "joe", "jow");
        owner.setCity("City");
        owner.setTelephone("1231231231");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("joe", owner.getFirstName(), "First name failed"),
                        () -> assertEquals("jow", owner.getLastName(), "Lastname name failed"),
                        () -> assertAll("Owner Properties",
                                () -> assertEquals("City", owner.getCity(), "City failed"),
                                () -> assertEquals("1231231231", owner.getTelephone(), "Telephone failed"))
                ));
    }
}