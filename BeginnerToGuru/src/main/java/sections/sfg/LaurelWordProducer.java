package sections.sfg;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@Profile("laurel")
@Component
public class LaurelWordProducer implements WordProducer{
    @Override
    public String getWork() {
        return "Laurel";
    }
}
