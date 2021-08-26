import TestCli.TestCliParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestCliParserTest {

    @Test
    void testParseWithoutQuotes() {
        TestCliParser parser = new TestCliParser();
        List<String> result = parser.parse("/command param1 param2");
        assertEquals(result, List.of("/command", "param1", "param2"));
    }

    @Test
    void testParseAllWithQuotes() {
        TestCliParser parser = new TestCliParser();
        List<String> result = parser.parse("/command \"param 1\" \"param 2\" \"param 3\"");
        assertEquals(result, (List.of("/command", "param 1", "param 2", "param 3")));
    }

    @Test
    void testParseWithOneFirstQuote() {
        TestCliParser parser = new TestCliParser();
        List<String> result = parser.parse("/command \"param1\" param2");
        assertEquals(result, (List.of("/command", "param1", "param2")));
    }

    @Test
    void testParseWithOneFirstQuoteWitSpaces() {
        TestCliParser parser = new TestCliParser();
        List<String> result = parser.parse("/command \"param1 second third\" param2");
        assertEquals(result, (List.of("/command", "param1 second third", "param2")));
    }
}