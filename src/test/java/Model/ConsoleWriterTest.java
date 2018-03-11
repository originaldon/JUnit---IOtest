package Model;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ConsoleWriterTest {

    @Test
    public void testConsoleWriter() {

        String testString = "Write something";
        StringWriter testWriter = new StringWriter();

        ConsoleWriter consoleWriter = new ConsoleWriter(new PrintWriter(testWriter));
        consoleWriter.writeLine(testString);
        testWriter.flush();

        //System.out.println(testWriter.toString());
        //System.out.println(testString);

        Assert.assertFalse(testWriter.toString().equals(testString));
        Assert.assertTrue(testString.equals(testWriter.toString().trim()));

        consoleWriter.write(testString);
        testWriter.flush();
        //System.out.println(testWriter.toString());
        //Andre systemer kunne bruge andre tags end \r\n
        Assert.assertTrue(testWriter.toString().equals(testString + "\r\n" + testString));

    }
}
