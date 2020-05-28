package rpis81.mironyuk.oop.model;

public interface Account {
    String number="";
    double balance = 0;

    public String getNumber();

    public void setNumber(String number);

    public double getBalance();
    public void setBalance(double balance);
}
