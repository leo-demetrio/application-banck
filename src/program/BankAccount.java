package program;

import util.NumberFormat;

public class BankAccount {
    private static int counterAccount = 1;

    private int numberAccount;
    private Client client;
    private Double balance = 0D;

    public void deposit(Double value){
        if(value > 0){
            setBalance(value + balance);
            System.out.println("Deposit success");
        }else {
            System.out.println("Deposit fail");
        }
    }
    public void withdraw(Double value){
        if(value > 0 && this.balance >= value){
            setBalance(getBalance() - value);
            System.out.println("Withdraw success");
        }else {
            System.out.println("Withdraw fail");
        }
    }
    public void transfer(BankAccount clientDeposit,Double value){
        if(value > 0 && this.balance >= value){
            setBalance(getBalance() - value);
            clientDeposit.setBalance(clientDeposit.getBalance() + value);
            System.out.println("Count sender: " + this.client.getName());
            System.out.println("Count recipient: " + clientDeposit.client.getName());
            System.out.println("Balance recipient: " + clientDeposit.getBalance());
            System.out.println("Balance sender: " + this.getBalance());
            System.out.println("Transfer success");
        }else {
            System.out.println("Transfer fail");
        }
    }
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
                "\nBalance: " + NumberFormat.doubleToString(this.getBalance()) + "\n";
    }
}
