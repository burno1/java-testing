package sections.six;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * Author: Bruno Fernandes
 * Created at : 05/03/2021
 */
public class CustomArgsProvider  implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Fl",1,2),
                Arguments.of("OH",1,3),
                Arguments.of("Mi",3,4)
        );
    }
}
