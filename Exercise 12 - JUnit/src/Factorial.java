package src;

public class Factorial {
  public Factorial() {}

  public int factorial(int n) {
    int result = 1;
    for (int i = n; i > 0; i--) {
      result *= i;
    }
    return result;
  }
}
