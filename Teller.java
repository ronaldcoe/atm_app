import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;



public class Teller {
    
    int account;
    Screen screen = new Screen();
    Scanner scanner = new Scanner(System.in);

  


    public String[] readAccount() {
        String[] s = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(account+".txt"));
            s = br.readLine().split(",");
            
            
        }catch(Exception ex) {
            System.out.println("Something went wrong readaccount");
        }
        
        return s;
        
    }

    public boolean checkPermission() {
        String[] s;
        account = screen.getInput("What is your account number?: ");
        int pin = screen.getInput("What is your pin?: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(account+".txt"));
            s = br.readLine().split(",");
            if (Integer.parseInt(s[0]) == account && Integer.parseInt(s[1]) == pin) {
                return true;
            }
            
        }catch(Exception ex) {
            System.out.println("Something went wrong checkpermission");
            
        }
        return false;
    }

    //Display welcome message and options
    public int getOption() {
        screen.displayMessage("Welcome to the ATM app. How can I help you today?\n1. Open a new account\n2. Check Balance\n3. Make a deposit\n4. Withdraw money\n5. Quit");
        System.out.print("> ");
        int option = scanner.nextInt();
        return option;

    }

    public void sayQuitMessage() {
        screen.displayMessage("Thank you for using our system. See you soon!");
    }

    // create account
    public void createAccount() {
        System.out.println("Create Account");
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Set a 4-digits pin: ");
        short pin = scanner.nextShort();
        int newAccountNumber = (int)Math.floor(Math.random()*9999);
        String newAccountHolder = name + " " + lastName;
        short newAccountPin = pin; 

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(newAccountNumber+".txt"));
            bw.write( newAccountNumber + "," + newAccountPin + "," + newAccountHolder + "," + 0);
            bw.close();
            System.out.println("Your account number is: "+ newAccountNumber);
        }catch(Exception ex) {
            return;
        }

    }

}
