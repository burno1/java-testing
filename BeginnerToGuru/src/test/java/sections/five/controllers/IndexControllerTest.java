package sections.five.controllers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import sections.five.exceptions.ValueNotFoundException;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        //AssertJ stuff
        assertThat(controller.index()).isEqualTo("index");
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

    @DisplayName(value = "Test if the OS is a MAC")
    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMAc() {
    }

    @DisplayName(value = "Test if the OS is a Windows")
    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {
    }

    @DisplayName(value = "Test if the jre is v8")
    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8() {
    }

    @DisplayName(value = "Test if the jre is v11")
    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testOnJava11() {
    }

    // Don't know how to make this work, bye!
    @DisplayName(value = "Test if user is {INSERT YOUR USERNAME HERE}}")
    @EnabledIfEnvironmentVariable(named="USER", matches = "yourname")
    @Test
    void testUserBruno() {
    }

}