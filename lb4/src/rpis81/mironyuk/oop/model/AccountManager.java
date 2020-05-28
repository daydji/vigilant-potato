package rpis81.mironyuk.oop.model;

import java.util.Arrays;
import java.util.List;

public class AccountManager {
    Client[] individuals;
    int size;

    public boolean add(Individual individual)
    {

        for (int i=0;i<individuals.length;i++)
            if(individuals[i]==null)
            {
                individuals[i]=individual;
                size=size<=i?i+1:size;
                return true;
            }
        Client[] individuals1=individuals;
        individuals=new Client[individuals1.length*2];
        for (int i=0;i<size;i++)
            add(i,individuals1[i]);
        return add(individual);

    }

    public boolean add(int index, Client individual)
    {
        if(index>=individuals.length){
            Client[] individuals1=individuals;
            individuals=new Individual[individuals.length*2];
            for (int i=0;i<size;i++)
                add(i,individuals1[i]);
            add(index,individual);}
        else set(index,individual);

        if (index>=size)
            size=index+1;
        return true;
    }

    public Client get(int index)
    {
        return individuals[index];
    }

    public Client set(int index, Client individual)
    {
        Client individ=individuals[index];
        individuals[index]=individual;
        return individ;
    }

    public Client remove(int index)
    {
        Client individ=individuals[index];
        for(;index<size-1;index++)
            individuals[index]=individuals[index+1];
        individuals[index]=null;
        return individ;
    }

    public int size()
    {
        int size=0;
        for(Client individual:individuals)
            if(individual!=null)size++;
        return size;
    }

    public Client[] getClients()
    {
        Client[] clients=new Client[size()];
        int i=0;
        for (Client individual:this.individuals)
            if(individual!=null)
                clients[i++]=individual;
        return clients;
    }

    public Client[] sortedByBalanceClientss()
    {
        Client[] individuals=getClients().clone();
        Client tmp;
        for (int i=0,k,f;i<individuals.length-1;i++){//Selection sort
            for( k=i+1, f=i;k<individuals.length;k++)
                if(individuals[f].totalBalance()<individuals[k].totalBalance())
                    f=k;
            tmp=individuals[f];
            individuals[f]=individuals[i];
            individuals[i]=tmp;
        }
        return individuals;
    }

    public DebitAccount getAccount(String accountNumber)
    {
        for (Client individual:individuals)
            if(individual.hasAccount(accountNumber))
                return (DebitAccount) individual.get(accountNumber);
        return null;
    }

    public DebitAccount removeAccount(String accountNumber)
    {
        for (Client individual:individuals)
            if(individual.hasAccount(accountNumber))
                return (DebitAccount) individual.remove(accountNumber);
        return null;
    }

    public Account setAccount(String accountNumber, DebitAccount account)
    {
        for (Client individual:individuals)
            if(individual.hasAccount(accountNumber)){
                int i=0;
                for (Account account1:individual.getAccounts())
                    if(account1.getNumber().equals(accountNumber))
                    {
                        return individual.set(i,account);
                    }
                    else i++;
            }

        return null;
    }

    public AccountManager(int quantity)
    {
        individuals=new Client[quantity];
    }

    public AccountManager(Client[] individuals)
    {
        this.individuals=individuals.clone();
    }

    public Client[] getCreditedClients()
    {
        List<Client> clients= Arrays.asList(individuals);
        for (Client client: clients) {
            if(client.getCredits().length==0)clients.remove(client);
        }
        return clients.toArray(new Client[0]);
    }

    public Client[] getBadClients()
    {
        List<Client> clients= Arrays.asList(getCreditedClients());
        for (Client client: clients) {
            if(!client.getClientStatus().equals(ClientStatus.BAD))clients.remove(client);
        }
        return clients.toArray(new Client[0]);
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        for (Client account:getClients()) {
            builder.append(account.toString());
            builder.append('\n');
        }
        return builder.toString();
    }
}
