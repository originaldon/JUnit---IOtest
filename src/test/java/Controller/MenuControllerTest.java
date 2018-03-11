package Controller;

import Model.ConsoleReader;
import Model.ConsoleWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class MenuControllerTest {

    @Test
    public void testMenuController() {

        StringWriter testWriter = new StringWriter();

        MenuController menuController = new MenuController(new ConsoleWriter(new PrintWriter(testWriter)), new ConsoleReader(new Scanner("1\n1\n44993388\nNavn Efternavnsen\n1\n12\n10-14")));

        menuController.menu();

        testWriter.flush();

        String testString = testWriter.toString();
        System.out.println(testString);
        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(testString);

        String lastLineTest = "";
        while (scanner.hasNext()){

            lastLineTest = scanner.nextLine();
        }
        Assert.assertTrue(lastLineTest.equals("Indtast tlfnr:Indtast navn:Indtast sal:Indtast række:Indtast sæde(r):"));

    }
}
