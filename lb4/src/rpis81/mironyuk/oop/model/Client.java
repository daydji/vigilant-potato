package rpis81.mironyuk.oop.model;

public interface Client {
    ClientStatus status=null;
    public boolean add(Account account);
    public boolean add(int index, Account account);
    public Account get(int index);
    public Account get(String accountNumber);
    public boolean hasAccount(String accountNumber);
    public  Account set(int index,Account account);
    public Account remove(int index);
    public Account remove(String accountNumber);
    public int size();
    public Account[] getAccounts();
    public Account[] sortedAccountsByBalance();
    public double totalBalance();
    public String getName();
    public void setName(String name);
    public int getClientPoints();
    public void increase(int points);
    public default ClientStatus getClientStatus()
    {
        return  status;
    }

    public Account[] getCredits();


}