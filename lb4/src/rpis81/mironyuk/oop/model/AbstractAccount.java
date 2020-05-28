package rpis81.mironyuk.oop.model;

public abstract class AbstractAccount implements Account, Cloneable{
    protected String number;
    protected double balance;

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number=number;
    }

    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double balance)
    {
        this.balance=balance;
    }

    public AbstractAccount()
    {
        number="";
        balance=0;
    }

    public AbstractAccount(String number, double balance)
    {
        this.number=number;
        this.balance=balance;
    }

    @Override
    public String toString()
    {
        return String.format("number: %s balance %d",number, balance);
    }

    @Override
    public int hashCode() {
        return (int) (number.hashCode()*balance);
    }

    @Override
    public boolean equals(Object obj) {
        return number.equals(((AbstractAccount)obj).number)&&balance==((AbstractAccount)obj).balance;
    }

    protected Object clone()throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }
}
