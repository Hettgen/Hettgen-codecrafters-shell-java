// Uncomment this block to pass the first stage
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        // You can use print statements as follows for debugging, they'll be visible when running tests.
        // System.out.println("Logs from your program will appear here!");

        String[] paths = System.getenv("PATH").split(":");

        // Uncomment this block to pass the first stage
        HashMap<String, String> commandList = new HashMap<String, String>();
        commandList.put("echo", "a shell builtin");
        commandList.put("exit", "a shell builtin");
        commandList.put("cat", "/bin/cat");
        commandList.put("type", "a shell builtin");
        commandList.put("pwd", "a shell builtin");

        Scanner scanner = new Scanner(System.in);
        

        while(true){

            

            System.out.print("$ ");
            
            String input = scanner.nextLine();

            String[] parameters = input.split(" ", 2);

            String command = parameters[0];
            String condition = "";
            if(parameters.length > 1){
                condition = parameters[1];
            }

            
            // if((input.indexOf(" ", 0) >= 0)){
            //     command = input.substring(0, input.indexOf(" ", 0));

            // }
            
            // if command not in current list
            if(commandList.get(parameters[0]) == null){

                String commandPath = searchPath(paths, command);

                // search path for entered command and execute
                if(commandPath != ""){
                    executeExternal(commandPath, condition);
                }
                else{
                    System.out.println(input + ": command not found");
                }
                continue;
            }

            // PWD command
            if(command.equals("pwd")){
                System.out.println(getWorkingDirectory());
            }

            // TYPE command
            if(command.equals("type")){

                String pathLocation = searchPath(paths, condition);

                if(commandList.get(condition) != null){


                    System.out.print(condition + " is " + commandList.get(condition) + "\n");
                }
                else{
                    if(pathLocation.equals("")){
                        System.out.println(condition + ": not found");
                    }
                    else{
                        System.out.println(condition + " is " + pathLocation);
                    }
                }
                continue;
            }

            // EXIT command
            if(parameters[0].equals("exit")){
                System.exit(Integer.valueOf(condition));
            }
            // ECHO command
            if(parameters[0].equals("echo")){
                System.out.print(condition + "\n");
                continue;
            }

        }
        
    }

    public static String searchPath(String[] path, String command){

        for (String string : path) {


            String[] allFiles = getFiles(string);

            if(allFiles == null){
                continue;
            }


            // System.out.println(string.substring(string.lastIndexOf("/")+1));

            for(int i = 0; i < allFiles.length; i++){
                if(allFiles[i].equals(command))
                    return string + "/" + command;
            }
            
        }
        return "";
    }

    public static String[] getFiles(String dir){
        
        File[] files = new File(dir).listFiles();

        if(files == null){
            return null;
        }

        String[] allFiles = new String[files.length];

        for(int i = 0; i < allFiles.length; i++){
            allFiles[i] = files[i].getName();
        }

        return allFiles;
    }

    public static String getWorkingDirectory(){
        return  System.getProperty("user.dir");
    }

    // Logic for CD
    public static boolean changeWorkingDirectory(String parameter){

        String userDir = System.getProperty("user.dir");

        if(userDir != null){
            
        }

        if(parameter.equals("./"))
        System.setProperty("user.dir", "");

        File directory = new File(parameter).getAbsoluteFile();
        boolean result = false;

        if(directory.exists() || directory.mkdirs())
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        
        return result;

    }


    public static void executeExternal(String command, String parameter){
        try {

            // Process proc = run.exec(command, parameter);
            // Runtime run = Runtime.getRuntime();
            Process process = new ProcessBuilder(command, parameter).start();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            process.waitFor();
            in.close();

            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } 
    }


}
