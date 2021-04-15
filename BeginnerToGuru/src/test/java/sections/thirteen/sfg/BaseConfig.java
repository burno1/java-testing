package sections.thirteen.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sections.sfg.HearingInterpreter;
import sections.sfg.WordProducer;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@Configuration
public class BaseConfig {

    @Bean
    HearingInterpreter hearingInterpreter(WordProducer wordProducer){
        return new HearingInterpreter(wordProducer);
    }

}
