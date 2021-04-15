package sections.thirteen.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sections.sfg.YannyWordProducer;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@Configuration
public class YannyConfig {

    @Bean
    YannyWordProducer laurelWordProducer(){
        return new YannyWordProducer();
    }
}
