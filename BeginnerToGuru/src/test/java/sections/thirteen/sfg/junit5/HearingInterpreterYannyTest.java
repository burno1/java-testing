package sections.thirteen.sfg.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sections.sfg.HearingInterpreter;
import sections.thirteen.sfg.BaseConfig;
import sections.thirteen.sfg.YannyConfig;

import static org.junit.Assert.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@SpringJUnitConfig(classes = {BaseConfig.class, YannyConfig.class})
class HearingInterpreterYannyTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @DisplayName(value = "what do i hear?")
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Yanny", word);
    }
}