import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Account {

    private String accountBalance;
    private String accountNumber;
    private String accountPin;
    private String accountHolder;
    Screen screen = new Screen();

    public Account(String number, String pin, String holder, String balance) {
        accountBalance = balance;
        accountNumber = number;
        accountPin = pin;
        accountHolder = holder;

    }

    public String getBalance() {
        return accountBalance;
    }

    public void withdrawMoney() {
        int balance = Integer.parseInt(accountBalance);
        int amount = screen.getInput("How much you want to withdraw?: ");
        while (amount > balance) {
            System.out.println("Unsufficient funds");
            amount = screen.getInput("How much you want to withdraw?: ");
        }
        accountBalance = Integer.toString(balance -= amount);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber+".txt"));
            bw.write(accountNumber + "," + accountPin + "," + accountHolder + "," + accountBalance);
            bw.close();
        }catch(Exception ex) {
            System.out.println("Something went wrong");;
        }
        

        
    }

    public void depositMoney() {
        int balance = Integer.parseInt(accountBalance);
        int amount = screen.getInput("How much you want to deposit? ");
        accountBalance =  Integer.toString(balance += amount);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber+".txt"));
            bw.write(accountNumber + "," + accountPin + "," + accountHolder + "," + accountBalance);
            bw.close();
        }catch(Exception ex) {
            System.out.println("Something went wrong");
        }
    }
}