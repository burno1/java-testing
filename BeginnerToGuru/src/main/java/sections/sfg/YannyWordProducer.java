package sections.sfg;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Author: Bruno Fernandes
 * Created at : 13/04/2021
 */
@Profile("yanny")
@Component
public class YannyWordProducer implements WordProducer{

    @Override
    public String getWork() {
        return "Yanny";
    }
}
