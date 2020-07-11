package greet;

import net.greet.Greet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GreeterTest {

    @Test
    public void acceptMethod() {
        Greet greet = new Greet();
        assertEquals(greet, greet);
    }
}
