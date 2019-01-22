package N.Probability.Medium.MedianTracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianTrackerTest {
    private static MedianTracker medianTracker;

    @BeforeAll
    static void setInstance() {
        medianTracker = new MedianTracker();
    }

    @Test
    void test() {
        medianTracker.read(1);
        assertEquals(Double.valueOf(1.0), medianTracker.median());

        medianTracker.read(2);
        assertEquals(Double.valueOf(1.5), medianTracker.median());

        medianTracker.read(3);
        assertEquals(Double.valueOf(2.0), medianTracker.median());

        medianTracker.read(10);
        assertEquals(Double.valueOf(2.5), medianTracker.median());
    }
}