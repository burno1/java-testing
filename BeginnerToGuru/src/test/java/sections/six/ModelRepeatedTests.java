package sections.six;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
@Tag(value = "repeated")
public interface ModelRepeatedTests {
    @BeforeEach
    default void beforeEachConsoleOutput(TestInfo testInfo){
        System.out.println("Running Test - "+ testInfo.getDisplayName());
    }
}
