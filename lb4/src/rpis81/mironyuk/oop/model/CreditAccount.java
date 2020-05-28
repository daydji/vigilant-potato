package rpis81.mironyuk.oop.model;

public class CreditAccount extends AbstractAccount implements Credit {
    double AnnualPercentageRate=0;

    public double getAnnualPercentageRate() {
        return AnnualPercentageRate;
    }

    public void setAnnualPercentageRate(double AnnualPercentageRate) {
        this.AnnualPercentageRate=AnnualPercentageRate;
    }

    public CreditAccount()
    {
        AnnualPercentageRate=30;
    }

    public CreditAccount(String number,double balance, double AnnualPercentageRate)
    {
        super(number, balance);
        this.AnnualPercentageRate=AnnualPercentageRate;
    }

    @Override
    public String toString() {
        return String.format("Credit account - number: %s balance: %d APR: %d",number,balance, AnnualPercentageRate);
    }

    @Override
    public int hashCode() {
        return super.hashCode()*71;
    }

    protected Object clone()throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    @Override
    public boolean equals(Object obj) {
        return number.equals(((CreditAccount)obj).number)&&balance==((CreditAccount)obj).balance&&AnnualPercentageRate==((CreditAccount)obj).AnnualPercentageRate;
    }
}

