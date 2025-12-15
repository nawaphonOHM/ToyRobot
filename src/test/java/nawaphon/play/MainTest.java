package nawaphon.play;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {

        outputStreamCaptor = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }


    @Test
    public void testSetA() {

        final var input = new StringJoiner("\n", "", "\n");

        input.add("PLACE 0,0,NORTH")
                .add("MOVE")
                .add("REPORT");

        final var mockSystemIn = input.toString();

        System.setIn(new ByteArrayInputStream(mockSystemIn.getBytes(StandardCharsets.UTF_8)));

        Main.main(new String[]{});

        final var output = outputStreamCaptor.toString().split("\n");

        assertEquals(2, output.length);
        assertEquals("Welcome to the Toy Robot!", output[0]);
        assertEquals("Output: 0,1,NORTH", output[1]);

    }
}