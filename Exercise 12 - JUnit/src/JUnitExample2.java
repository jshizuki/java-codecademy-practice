package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExample2 {
  int a;

  @BeforeEach
  public void beforeTest() {
    a = 10;
  }

  @Test
  public void test1() {
    a = a - 5;
    assertEquals(5, a);
  }

  @Test
  public void test2() {
    a = a + 7;
    assertEquals(17, a);
  }

  @Test
  public void test3() {
    assertEquals(10, a);
  }
}
