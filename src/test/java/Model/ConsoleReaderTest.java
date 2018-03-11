package Model;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ConsoleReaderTest {

    @Test
    public void testConsoleReader(){

        ConsoleReader consoleReader = new ConsoleReader(new Scanner("TEST\nTESTTEST\n12\n"));

        String line = consoleReader.readLine();


        Assert.assertThat(line, CoreMatchers.is("TEST"));
        Assert.assertTrue(consoleReader.readLine().equals("TESTTEST"));
        Assert.assertThat(consoleReader.readChoice(), CoreMatchers.is(12));
    }
}
