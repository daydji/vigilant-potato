package rpis81.mironyuk.oop.model;

public class DebitAccount extends AbstractAccount {
    String number;
    double balance;



    public DebitAccount()
    {
        super();
    }

    public DebitAccount(String number, double balance)
    {
        super(number, balance);
    }

    @Override
    public String toString() {
        return String.format("Debit account - number: %s balance: %d",number,balance);
    }

    @Override
    public int hashCode() {
        return super.hashCode()*53;
    }

    protected Object clone()throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}
