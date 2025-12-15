package nawaphon.play;

import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;

    @BeforeEach
    void setUp() {
    }
}