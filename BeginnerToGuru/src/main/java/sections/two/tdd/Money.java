package sections.two.tdd;

public class Money implements Expression {
    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public static Money dollar (int amount){
        return new Money(amount,"USD");
    }

    public static Money franc (int amount){
        return new Money(amount,"CHF");
    }

    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount && this.currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    /**
     * Returns a new instance of {@link Money} but multiplied by the parameter
     * @param multiplier number that defines by how much the amount will be multiplied
     * @return new {@link Money}
     */
    @Override
    public Expression times(int multiplier){
        return new Money(amount * multiplier, this.currency);
    }
    @Override
    public Expression plus(Expression added){
        return new Sum(this,added);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount/bank.rate(this.currency, to), to);
    }
}
