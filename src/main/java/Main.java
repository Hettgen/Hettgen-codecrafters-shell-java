// Uncomment this block to pass the first stage
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        // System.out.println("Logs from your program will appear here!");

        // Uncomment this block to pass the first stage
        HashMap<String, String> commandList = new HashMap<String, String>();
        commandList.put("echo", " a shell builtin");
        commandList.put("exit", " a shell builtin");
        commandList.put("cat", "/bin/cat");

        Scanner scanner = new Scanner(System.in);
        

        while(true){
            System.out.print("$ ");
            
            String input = scanner.nextLine();

            String[] parameters = input.split(" ", 2);

            // if((input.indexOf(" ", 0) >= 0)){
            //     command = input.substring(0, input.indexOf(" ", 0));

            // }

            if(commandList.get(parameters[0]) == null){
                System.out.println(input + ": command not found");
                continue;
            }

            if(parameters[0].equals("type")){
                if(commandList.get(parameters[1]) != null){
                    System.out.print(parameters[1] + " is" + commandList.get(parameters[1]) + "\n");
                }
            }

            if(parameters[0].equals("exit")){


                System.exit(Integer.valueOf(parameters[1]));
            }
            if(parameters[0].equals("echo")){
                System.out.print(parameters[1] + "\n");
            }

        }
        
        
    }
}
