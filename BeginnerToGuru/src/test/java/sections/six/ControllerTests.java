package sections.six;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag(value = "controller")
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println(this.getClass().getInterfaces()[0].getSimpleName() + " - Before All Method");
    }
}
