package sections.six;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import sections.five.model.OwnerType;

import java.util.stream.Stream;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
public class ParameterizedTests {

    @DisplayName("Value source test")
    @ParameterizedTest(name= "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"John","Joahne","Fulano"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum source test")
    @ParameterizedTest(name= "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void eunmTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName(value = "Csv input test")
    @ParameterizedTest(name= "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,3,3",
    })
    void csvTestMethod(String stateName, int val1, int val2) {
        System.out.println(stateName + "-" + val1 + "-" +  val2);
    }

    @DisplayName(value = "Csv from file test")
    @ParameterizedTest(name= "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileMethod(String stateName, int val1, int val2) {
        System.out.println(stateName + "-" + val1 + "-" +  val2);
    }

    @DisplayName(value = "Method Provider Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + "-" + val1 + "-" +  val2);
    }

    @DisplayName(value = "Custom Provider Test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String stateName, int val1, int val2) {
        System.out.println(stateName + "-" + val1 + "-" +  val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("Fl",1,2),
                Arguments.of("OH",1,3),
                Arguments.of("Mi",3,4)
        );
    }
}
