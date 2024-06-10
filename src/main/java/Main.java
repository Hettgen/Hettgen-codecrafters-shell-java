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

            String command = input.substring(0, input.indexOf(" ", 0));

            if(command.equals("exit 0")){
                System.exit(0);
            }
            if(command.equals("echo")){
                System.out.print(input.substring(command.length()) + "\n");
            }
            else{
                System.out.println(input + ": command not found");
                System.exit(0);
            }

        }
        
        
    }
}
