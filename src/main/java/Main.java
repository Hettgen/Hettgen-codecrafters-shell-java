// Uncomment this block to pass the first stage
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        // System.out.println("Logs from your program will appear here!");

        // Uncomment this block to pass the first stage
        
        

        while(true){
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if(input.equals("exit 0")){
                System.exit(0);
            }

            System.out.println(input + ": command not found");

            

        }
        
        
    }
}
