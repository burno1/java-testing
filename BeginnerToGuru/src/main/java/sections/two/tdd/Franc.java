package sections.two.tdd;

public class Franc extends Money{

    public Franc(int amount, String currency){
        super(amount, currency);
    }

    @Override
    protected String currency() {
        return currency;
    }

}

