package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class TestProcessBuilder {

    static List<String> errorList = new ArrayList<>();

    static void createProcess(String command) throws java.io.IOException {

        List<String> input = Arrays.asList(command.split(" "));

        ProcessBuilder processBuilder = new ProcessBuilder(input);
        BufferedReader bufferReader = null;
        try {
            Process proc = processBuilder.start();
            InputStream inputStream = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(isr);

            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line );
            }
            bufferReader.close();
        } catch (java.io.IOException ioe) {
            if (!command.equalsIgnoreCase("Showerrlog")) {
                errorList.add(command);
                System.err.println("Error : " + ioe);
            }
//            System.err.println(ioe);
        } finally {
            if (bufferReader != null) {
                bufferReader.close();
            }
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        String commandLine;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n***** Welcome to the Java Command Shell *****");
        System.out.println("If you want to exit the shell, type END and press RETURN.\n");
        while (true) {
               System.out.print("jsh>");
            commandLine = scanner.nextLine();
            // if user entered a return, just loop again
            if (commandLine.equals("")) {
                continue;
            }
            if (commandLine.toLowerCase().equals("end")) { //User wants to end shell
                System.out.println("\n***** Command Shell Terminated. See you next time. BYE for now. *****\n");
                scanner.close();
                System.exit(0);
            }
            if (commandLine.equalsIgnoreCase("Showerrlog")){
                if (!TestProcessBuilder.errorList.isEmpty()){
                    System.out.println(" ----- Error-commands history ------");
                    for (int i = 0; i < TestProcessBuilder.errorList.size() ; i++) {
                        System.out.println(" * " + TestProcessBuilder.errorList.get(i));
                    }
                    System.out.println(" ------------------------------------------");
                }else {
                        System.out.println("No previous error history");
                    }
            }
//            createProcess(commandLine);
              Thread x = new Thread(new newThread(commandLine));
              x.start();
        }   
    }
}

class newThread implements Runnable {
    private final String commandString;
    public newThread(String command) {
        this.commandString = command;
    }
    @Override
    public void run() {
        try {
            TestProcessBuilder.createProcess(commandString);
            System.out.println(commandString);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
