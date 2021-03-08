package sections.nine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
public class AnnotationMocksTest {
    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName(value = "Test Mock")
    @Test
    void testMock() {
        mapMock.put("keyvalue","foo");
    }
}
