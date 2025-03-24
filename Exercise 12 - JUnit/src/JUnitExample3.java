package src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExample3 {
  File file;
  FileWriter w;
  Scanner s;

  @BeforeEach
  public void beforeTest() throws IOException {
    file = new File("test.txt");
    w = new FileWriter(file);
    s = new Scanner(file);
  }

  @Test
  public void test1() throws IOException {
    w.write("Hello, Tokyo!");
    w.close();

    assertEquals("Hello, Tokyo!", s.nextLine());
  }

  @Test
  public void test2() throws IOException {
    w.write("Hello, Hong Kong!");
    w.close();

    assertEquals("Hello, Hong Kong!", s.nextLine());
  }

  @AfterEach
  public void afterTest() throws IOException {
    s.close();
    file.delete();
  }
}
