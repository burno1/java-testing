package sections.nine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

/**
 * Author: Bruno Fernandes
 * Created at : 08/03/2021
 */
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;


    @Test
    void testMock() {
        mapMock.put("keyvalue","foo");
    }


}
