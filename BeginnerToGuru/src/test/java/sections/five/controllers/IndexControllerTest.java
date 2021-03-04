package sections.five.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sections.five.exceptions.ValueNotFoundException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class IndexControllerTest {
    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName(value = "Test Proper View is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), () -> "Wrong View Returned bro" + "Make only if you have to");
    }

    @DisplayName("Test Exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @DisplayName(value = "Test timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(200);
        });
    }

    @Disabled("Demo of timeout preemptive")
    @DisplayName(value = "Test timeout Preemptively")
    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
        });
    }

    @DisplayName(value = "Testing Assumption")
    @Test
    void testAssumptionTrue() {
        assumeTrue("TEST".equalsIgnoreCase(System.getenv("SOME_VAR")));
    }

    @DisplayName(value = "Testing a valid Assumption")
    @Test
    void testAssumptionTrueIsTrue() {
        assumeTrue("TEST".equalsIgnoreCase("Test"));
    }
}