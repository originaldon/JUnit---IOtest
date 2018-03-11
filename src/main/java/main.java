import Controller.MenuController;
import Model.ConsoleReader;
import Model.ConsoleWriter;

import java.io.PrintWriter;
import java.util.Scanner;

public class main {

    public static void main(String[] args){

        MenuController menuController = new MenuController(new ConsoleWriter(new PrintWriter(System.out)), new ConsoleReader(new Scanner(System.in)));

        menuController.menu();
    }
}
