package sections.six.model;

import org.junit.jupiter.api.*;
import sections.six.ModelRepeatedTests;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
public class PersonRepeatedTests implements ModelRepeatedTests {

    @RepeatedTest(value= 10,name= "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("Repeated test")
    void myRepeatedTest() {
    }


    @DisplayName("Test with Dependency injection")
    @RepeatedTest(value = 5, name="{displayName}")
    void myRepeteadTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        //System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @DisplayName(value="My assignment RepeatedTest")
    @RepeatedTest(value = 5, name="{displayName}")
    void myAssignedRepeatedTest() {

    }
}
