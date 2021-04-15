package sections.sfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Author: Bruno Fernandes
 * Created at : 15/04/2021
 */
@Profile("externalized")
@Primary
@Component
public class PropertiesWordProducer implements WordProducer{
    private String word;

    @Value("${say.word}")
    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getWork() {
        return word;
    }
}
