package sections.nine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
public class InlineMockTest {

    @DisplayName(value = "Inline Mock Test")
    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);

        assertEquals(mapMock.size(), 0);
    }
}
