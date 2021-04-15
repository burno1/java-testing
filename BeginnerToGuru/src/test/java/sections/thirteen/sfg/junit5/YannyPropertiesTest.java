package sections.thirteen.sfg.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sections.sfg.HearingInterpreter;

import static org.junit.Assert.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@TestPropertySource("classpath:yanny.properties")
@ActiveProfiles("externalized")
@SpringJUnitConfig(classes = YannyPropertiesTest.TestConfig.class)
class YannyPropertiesTest {
    @Autowired
    HearingInterpreter hearingInterpreter;

    @DisplayName(value = "what do i hear?")
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("Yanny",word);
    }

    @Configuration
    @ComponentScan("sections.sfg")
    static class TestConfig{}
}
