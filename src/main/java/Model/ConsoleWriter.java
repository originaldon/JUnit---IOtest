package Model;

import java.io.PrintWriter;

public class ConsoleWriter {

    private PrintWriter writer;

    public ConsoleWriter(PrintWriter printWriter){

        writer = printWriter;
    }

    public void writeLine(String output){

        writer.println(output);
        writer.flush();
    }

    public void write(String output){

        writer.print(output);
        writer.flush();
    }
}
