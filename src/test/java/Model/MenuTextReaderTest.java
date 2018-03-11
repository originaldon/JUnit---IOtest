package Model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class MenuTextReaderTest {

    @Test
    public void testMenuTextReader() {

        MenuTextReader menuTextReader = new MenuTextReader();
        //hovedmenuer
        final String menu = "src/main/java/View/menu.txt";
        final String book = "src/main/java/View/bookmenu.txt";
        //private static final String sale = "src/main/java/View/salesmenu.txt";
        //interaktive forespørgelser
        final String booking = "src/main/java/View/booking.txt";

        String fullMenu = menuTextReader.fullMenu(menu);
        Scanner scanner = new Scanner(fullMenu);
        System.out.println(fullMenu);

        int lines = 0;
        while (scanner.hasNext()){
            lines++;
            scanner.nextLine();
        }
        Assert.assertTrue(lines == 10);

        String[] interactiveMenu = menuTextReader.interactiveMenu(booking);
        String[] interactiveMenuTest = {"Indtast tlfnr:", "Indtast navn:", "Indtast sal:", "Indtast række:", "Indtast sæde(r):"};

        System.out.println(Arrays.toString(interactiveMenu));

        Assert.assertEquals(interactiveMenu, interactiveMenuTest);
    }
}
