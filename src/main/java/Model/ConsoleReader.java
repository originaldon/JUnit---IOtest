package Model;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner scanner = null;

    public ConsoleReader(Scanner scanner){

        this.scanner = scanner;
    }

    public String readLine(){

        return scanner.nextLine();

    }

    public int readChoice(){

        //nextInt messes with readLine()
        return Integer.parseInt(scanner.nextLine());
    }

}
