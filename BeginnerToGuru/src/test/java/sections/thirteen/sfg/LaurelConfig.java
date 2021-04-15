package sections.thirteen.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sections.sfg.LaurelWordProducer;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@Configuration
public class LaurelConfig {

    @Bean
    LaurelWordProducer laurelWordProducer(){
        return new LaurelWordProducer();
    }
}
