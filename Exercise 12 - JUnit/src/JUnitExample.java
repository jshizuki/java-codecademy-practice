package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitExample {
  int a;

  @BeforeEach
  public void beforeTest() {
    a = 10;
  }

  @Test
  public void test() {
    assertEquals(10, a);
  }

  @Disabled
  public void ignoredTest() {
    assertEquals(50, a);
  }

  @AfterEach
  public void afterTest() {
    a = 0;
  }
}
