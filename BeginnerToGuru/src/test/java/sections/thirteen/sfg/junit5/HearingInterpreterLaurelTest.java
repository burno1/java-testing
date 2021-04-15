package sections.thirteen.sfg.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sections.sfg.HearingInterpreter;
import sections.thirteen.sfg.BaseConfig;
import sections.thirteen.sfg.LaurelConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@SpringJUnitConfig(classes = {BaseConfig.class, LaurelConfig.class})
class HearingInterpreterLaurelTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @DisplayName(value = "What do i hear?")
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Laurel",word);
    }
}