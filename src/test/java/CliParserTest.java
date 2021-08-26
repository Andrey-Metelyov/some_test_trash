import CliParser.CliParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CliParserTest {

    @Test
    void testParseWithoutQuotes() {
        CliParser parser = new CliParser();
        List<String> result = parser.parse("/command param1 param2");
        assertEquals(result, List.of("/command", "param1", "param2"));
    }

    @Test
    void testParseAllWithQuotes() {
        CliParser parser = new CliParser();
        List<String> result = parser.parse("/command \"param 1\" \"param 2\" \"param 3\"");
        assertEquals(result, (List.of("/command", "param 1", "param 2", "param 3")));
    }

    @Test
    void testParseWithOneFirstQuote() {
        CliParser parser = new CliParser();
        List<String> result = parser.parse("/command \"param1\" param2");
        assertEquals(result, (List.of("/command", "param1", "param2")));
    }

    @Test
    void testParseWithOneFirstQuoteWitSpaces() {
        CliParser parser = new CliParser();
        List<String> result = parser.parse("/command \"param1 second third\" param2");
        assertEquals(result, (List.of("/command", "param1 second third", "param2")));
    }
}