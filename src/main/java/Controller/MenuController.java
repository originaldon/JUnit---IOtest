package Controller;

import Model.ConsoleReader;
import Model.ConsoleWriter;
import Model.MenuTextReader;

import java.io.PrintWriter;
import java.util.Scanner;

public class MenuController {

    //hovedmenuer
    private static final String menu = "src/main/java/View/menu.txt";
    private static final String book = "src/main/java/View/bookmenu.txt";
    //private static final String sale = "src/main/java/View/salesmenu.txt";
    //interaktive forespørgelser
    private static final String booking = "src/main/java/View/booking.txt";

    private ConsoleWriter consoleWriter; // = new ConsoleWriter(new PrintWriter(System.out));
    private MenuTextReader menuTextReader = new MenuTextReader();
    private ConsoleReader consoleReader; // = new ConsoleReader(new Scanner(System.in));

    public MenuController(ConsoleWriter consoleWriter, ConsoleReader consoleReader){

        this.consoleWriter = consoleWriter;
        this.consoleReader = consoleReader;
    }

    public void menu() {

        consoleWriter.write(menuTextReader.fullMenu(menu));

        switch (consoleReader.readChoice()) {

            case 0:
                System.exit(1);
            case 1:
                bookingMenu();
                break;
            case 2: //sale();
                break;
            case 3: //movies();
                break;
            case 4: //stock(); ???
                break;
            case 5: //calendar();
                break;
            case 6: //statistics();
                break;
            default:
                menu();
        }
    }

    private void bookingMenu() {

        consoleWriter.write(menuTextReader.fullMenu(book));

        switch (consoleReader.readChoice()) {

            case 0:
                menu();
                break;
            case 1:
                reserveSeats();
                break;
            case 2: //displayBookings();
                break;
            case 3: //editBookings();
                break;
            default:
                bookingMenu();
        }
    }

    private void reserveSeats() {

        String[] reserveMenu = menuTextReader.interactiveMenu(booking);

        consoleWriter.write(reserveMenu[0]);
        String phone = consoleReader.readLine();
        consoleWriter.write(reserveMenu[1]);
        String name = consoleReader.readLine();
        consoleWriter.write(reserveMenu[2]);
        String venue = consoleReader.readLine();
        consoleWriter.write(reserveMenu[3]);
        String row = consoleReader.readLine();
        consoleWriter.write(reserveMenu[4]);
        String seats = consoleReader.readLine();

        seats = resolveSeatsInput(seats);

        //SQL - databasteting her

        //test
    /*
        System.out.println();
        System.out.println("tlfnr: " + phone);
        System.out.println("navn: " + name);
        System.out.print("sal: " + venue);
        System.out.print("række: " + row);
        System.out.print("sæde(r): " + seats); */
    }

    //gør det muligt at skrive seats som en kombination af sæder adskilt af mellemrum ("1 2 3")
    //og en rækkefølge af sæder aadskilt af bindestreg ("12-17")
    //ser ikke om det samme sæde kommer til at fremgå flere gange! Eller om sæde findes
    private String resolveSeatsInput(String seats) {

        int index = seats.indexOf('-');
        if (index < 0) {

            return seats;
        }
        return resolveDashes(index, seats);
    }

    private String resolveDashes(int index, String seats) {

        int frontIndex = index - 1;
        while (frontIndex >= 0 && Character.isDigit(seats.charAt(frontIndex))) {
            frontIndex--;
        }
        frontIndex++; //last index tested is either not there or not a digit

        int backIndex = index + 1;

        while (backIndex < seats.length() && Character.isDigit(seats.charAt(backIndex))) {
            backIndex++;
        }
        //backIndex--; //Index used with substring as end point so backIndex-- not needed

        int lastNumberInRange = Integer.parseInt(seats.substring(index + 1, backIndex));

        String returnString = seats.substring(0, index);

        for (int i = Integer.parseInt(seats.substring(frontIndex, index))+1; i < lastNumberInRange; i++) {

            returnString += " " + i;
        }

        return resolveSeatsInput(returnString + " " + seats.substring(index + 1));
    }
}
