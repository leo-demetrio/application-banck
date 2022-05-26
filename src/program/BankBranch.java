package program;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBranch {
    static Scanner input = new Scanner(System.in);
    static ArrayList<BankAccount> accounts;

    public static void main(String[] args) {
        accounts = new ArrayList<>();
        operators();
    }
    private static void operators(){
        System.out.println("**********************************");
        System.out.println("***** Bem vindo a nossa Conta ****");
        System.out.println("**********************************");
        System.out.println("****** Selecione a operação ******");
        System.out.println("**********************************");
        System.out.println("| Option 1 - New Account  |");
        System.out.println("| Option 2 - New Deposit  |");
        System.out.println("| Option 3 - New Withdraw |");
        System.out.println("| Option 4 - New Transfer |");
        System.out.println("| Option 5 - List         |");
        System.out.println("| Option 6 - Logout       |");

        int operator = input.nextInt();

        switch(operator){
            case 1:
                createAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withDraw();
                break;
            case 4:
                transfer();
                break;
            case 5:
                listing();
                break;
            case 6:
                System.out.println("Tanks");
                System.exit(0);

            default:
                System.out.println("Invalid option");
                operators();
                break;
        }
    }
    private static void createAccount(){
        System.out.println("\nNome: ");
        String name = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Client client = new Client(name, cpf, email);

        BankAccount account = new BankAccount(client);

        accounts.add(account);

        System.out.println("Back Account created with success");
        operators();
    }

    private  static BankAccount findBankAccount(int numberAccount){
        BankAccount account = null;
        if(accounts.size() > 0){
            for(BankAccount c: accounts){
                if(c.getNumberAccount() == numberAccount)
                    account = c;
            }
        }
        return account;
    }
    public static void deposit(){
        System.out.println("Number account banck");
        int numberAccount = input.nextInt();
        BankAccount account = findBankAccount(numberAccount);

        if(account == null) {
            System.out.println("Bank Account not found");
            return;
        }

        System.out.println("Value deposit");
        Double valueDeposit = input.nextDouble();
        account.deposit(valueDeposit);
        operators();
    }
    public static void withDraw(){
        System.out.println("Number account banck");
        int numberAccount = input.nextInt();
        BankAccount account = findBankAccount(numberAccount);

        if(account == null) {
            System.out.println("Bank Account not found");
            return;
        }
        System.out.println("Value withDraw");
        Double valueWithDraw = input.nextDouble();
        account.withdraw(valueWithDraw);
        operators();
    }
    public static void transfer(){
        System.out.println("Number account sender");
        int accountNumberSender = input.nextInt();
        BankAccount accountSender = findBankAccount(accountNumberSender);

        if(accountSender != null) {
            System.out.println("Number account recipient");
            int accountNumberRecipient = input.nextInt();
            BankAccount accountRecipient = findBankAccount(accountNumberRecipient);
            if(accountRecipient != null){
                System.out.println("Value transfer");
                double value = input.nextDouble();
                accountSender.transfer(accountRecipient,value);
            }
        }
        operators();
    }
    public static void listing(){

        if(accounts.size() <= 0) {
            System.out.println("Register account bank");
            return;
        }
        for(BankAccount account: accounts)
            System.out.println(account);

        operators();
    }


}
