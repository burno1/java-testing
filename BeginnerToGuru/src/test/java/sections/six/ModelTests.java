package sections.six;

import org.junit.jupiter.api.*;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
@Tag(value = "model")
public interface ModelTests {

    @BeforeEach
    @Test
    default void beforeEachOutput(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
