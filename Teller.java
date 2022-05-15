import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;



public class Teller {
    
    int account;
    Screen screen = new Screen();

  


    public String[] readAccount() {
        String[] s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(account+".txt"));
            s = br.readLine().split(",");
            return s;
            
        }catch(Exception ex) {
            System.out.println("Something went wrong");
        }
        return s;
        
        
    }

    public boolean checkPermission() {
        String[] s;
        int account = screen.getInput("What is your account number?: ");
        int pin = screen.getInput("What is your pin?: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(account+".txt"));
            s = br.readLine().split(",");
            if (Integer.parseInt(s[0]) == account && Integer.parseInt(s[1]) == pin) {
                return true;
            }
            
        }catch(Exception ex) {
            System.out.println("Something went wrong");
            
        }
        return false;
    }

  
}
