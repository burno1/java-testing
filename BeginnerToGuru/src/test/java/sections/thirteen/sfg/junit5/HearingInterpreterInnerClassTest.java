package sections.thirteen.sfg.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sections.sfg.HearingInterpreter;
import sections.sfg.LaurelWordProducer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@SpringJUnitConfig(classes = HearingInterpreterInnerClassTest.TestConfig.class)
class HearingInterpreterInnerClassTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @DisplayName(value = "what do i heaard?")
    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();
        assertEquals("Laurel", word);
    }

    @Configuration
    static class TestConfig{
        @Bean
        HearingInterpreter hearingInterpreter() {
            return new HearingInterpreter(new LaurelWordProducer());
        }
    }
}