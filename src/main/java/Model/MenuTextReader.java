package Model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuTextReader {

    public String fullMenu(String path) {

        try {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            return "Kunne ikke læse menu: " + ioe;
        }
    }

    public String[] interactiveMenu(String path) {

        //splits on all types of linebreaks!
        return fullMenu(path).split("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]");
    }
}
