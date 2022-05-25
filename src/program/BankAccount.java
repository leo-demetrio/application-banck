package program;

import util.NumberFormat;

public class BankAccount {
    private static int counterAccount = 1;

    private int numberAccount;
    private Client client;
    private Double balance = 0D;

    public BankAccount(Client client) {
        this.numberAccount = counterAccount;
        this.client = client;
        counterAccount += 1;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public String toString(){
        return "\nConta: " + this.numberAccount +
                "\nNome: " + this.client.getName() +
                "\nEmail: " + this.client.getEmail() +
                "\nEmail: " + this.client.getCpf() +
                "\nEmail: " + NumberFormat.doubleToString(this.getBalance()) + "\n";
    }
}
