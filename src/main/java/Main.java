// Uncomment this block to pass the first stage
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        // System.out.println("Logs from your program will appear here!");

        // Uncomment this block to pass the first stage
        Scanner scanner = new Scanner(System.in);
        

        while(true){
            System.out.print("$ ");
            
            String input = scanner.nextLine();

            String command = "";

            String[] parameters = input.split(" ", 2);

            // if((input.indexOf(" ", 0) >= 0)){
            //     command = input.substring(0, input.indexOf(" ", 0));

            // }
            

            if(parameters[0].equals("exit")){


                System.exit(Integer.valueOf(parameters[1]));
            }
            if(parameters[0].equals("echo")){
                System.out.print(parameters[1]);
            }
            else{
                System.out.println(input + ": command not found");
            }

        }
        
        
    }
}
