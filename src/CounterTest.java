import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {

    private Counter c;
    private Counter c2;

    @Before
    public void setUp() throws Exception {
        this.c = new Counter(1, 5);
        this.c2 = new Counter(1, 5);
    }

    @Test
    public void testIncrement () {
        assert(c instanceof Counter);
        c.increment();
        c.increment();
        assertEquals(3, c.getCounter());
    }

    @Test
    public void testIncrementOverflow () {
        assert(c instanceof Counter);
        for (int i = 0; i < 3; i++) {
            c.increment();
        }
        assertEquals(4, c.getCounter());
        c.increment();
        assertEquals(1, c.getCounter());
    }

    @Test
    public void testIncrementOverflowListener () {
        assert(c instanceof Counter);
        assert(c2 instanceof Counter);

        c.addListener(c2);
        for (int i = 0; i < 3; i++) {
            c.increment();
        }

        assertEquals(4, c.getCounter());
        assertEquals(1, c2.getCounter());

        c.increment();

        assertEquals(1, c.getCounter());
        assertEquals(2, c2.getCounter());
    }
}