import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("What is your name?");
    String customerName = input.nextLine();

    System.out.println("How much money do you have?");
    int money = input.nextInt();

    Customer customer = new Customer(customerName, money);

    TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);
    takeOutSimulator.startTakeOutSimulator();
  }
}
