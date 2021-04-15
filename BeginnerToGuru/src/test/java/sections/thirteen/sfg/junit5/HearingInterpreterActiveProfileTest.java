package sections.thirteen.sfg.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sections.sfg.HearingInterpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@ActiveProfiles("yanny")
@SpringJUnitConfig(classes = HearingInterpreterComponentScanTest.TestConfig.class)
public class HearingInterpreterActiveProfileTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @DisplayName(value = "What do i scan?")
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();
        assertEquals("Yanny", word);
    }

    @Configuration
    @ComponentScan("sections.sfg")
    static class TestConfig {
    }
}
