package sections.sfg;

import org.springframework.stereotype.Service;

/**
 * Author: Bruno Fernandes
 * Created at : 13/04/2021
 */
@Service
public class HearingInterpreter {
    private final WordProducer wordProducer;


    public HearingInterpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String whatIHeard(){

        return  wordProducer.getWork();
    }

}
