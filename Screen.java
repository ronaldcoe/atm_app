import java.util.Scanner;

public class Screen {
    
    public void displayMessage(String message) {
        System.out.println("----------------------------------------------");
        System.out.println(message);
        System.out.println("----------------------------------------------");
    }

    public int getInput(String inputMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputMessage);
        int choice = scanner.nextInt();
        return choice;
    }

    

}
