import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Account {

    private int accountBalance;
    private int accountNumber;
    private int accountPin;
    private String accountHolder;
    Screen screen = new Screen();

    public Account(int balance, int number, int pin, String holder) {
        accountBalance = balance;
        accountNumber = number;
        accountPin = pin;
        accountHolder = holder;

    }

    public Account(String string, String string2, String string3, String holder) {
    }

    public int getBalance() {
        return accountBalance;
    }

    public void withdrawMoney() {
        
        int amount = screen.getInput("How much you want to withdraw");
        while (amount > accountBalance) {
            System.out.println("Unsufficient funds");
            amount = screen.getInput("How much you want to deposit");
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber+".txt"));
            bw.write(accountNumber + "," + accountPin + "," + accountHolder + "," + accountBalance);
        }catch(Exception ex) {
            System.out.println("Something went wrong");;
        }
        accountBalance -= amount;

    }

    public void depositMoney() {
        int amount = screen.getInput("How much you want to deposit? ");
        accountBalance += amount;
    }
}