package sections.four;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {
    Greetings greetings;

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before - I am only called Once!!!");
    }

    @BeforeEach
    void setUp() {
        greetings =  new Greetings();
    }

    @Test
    void helloWorld() {
        assertEquals("Hello World", greetings.helloWorld());
    }

    @Test
    void testHelloWorld() {
        assertEquals("Hello Bruno", greetings.helloWorld("Bruno"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("In After Each........");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After!!! ***** - I am only called Once!!!");
    }
}