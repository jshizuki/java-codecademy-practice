package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactorialTest {
  Factorial ex = new Factorial();

  @Test
  public void testFactorial() {
    // First parameter is the expected value, second is the actual value
    assertEquals(120, ex.factorial(5));
    assertEquals(24, ex.factorial(4));
    assertEquals(1, ex.factorial(1));
    assertEquals(1, ex.factorial(0));
  }
}
