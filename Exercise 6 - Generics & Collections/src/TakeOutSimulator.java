import java.util.Scanner;

public class TakeOutSimulator {
  private Customer customer;
  private FoodMenu menu;
  private Scanner input;

  public TakeOutSimulator(Customer customer, Scanner input) {
    this.customer = customer;
    this.menu = new FoodMenu();
    this.input = input;
  }

  private <T> T getResponse(String userInputPrompt, UserInputRetriever<T> userInputRetriever)
      throws IllegalArgumentException, NumberFormatException {
    while (true) {
      try {
        System.out.println(userInputPrompt);
        String userInputStr = input.next();
        int userInput = Integer.parseInt(userInputStr);
        return userInputRetriever.produceOutput(userInput);
      } catch (NumberFormatException e) {
        System.out.println("Input is not a number.");
      } catch (IllegalArgumentException e) {
        System.out.println("Input is a number but not within valid options.");
      }
    }
  }

  // (1)
  private boolean shouldSimulate() {
    return getResponse("Enter 1 to CONTINUE simulation or 0 to EXIT program:", (selection) -> {
      if (selection == 1 && customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
        return true;
      } else if (selection == 0) {
        System.out.println("Bye! Please visit us again :)");
        return false;
      } else if (customer.getMoney() < menu.getLowestCostFood().getPrice()) {
        System.out.println("You don't have enough money to continue shopping :( - ending simulation...");
        return false;
      } else {
        throw new IllegalArgumentException();
      }
    });
  }

  // (2)
  private boolean isStillOrderingFood() {
    return getResponse("Enter 1 to CONTINUE shopping or 0 to CHECKOUT:", (selection) -> {
      if (selection == 1) {
        return true;
      } else if (selection == 0) {
        return false;
      } else {
        throw new IllegalArgumentException();
      }
    });
  }

  // (3)
  private Food getMenuSelection() {
    return getResponse("Today's Menu Options!\n" + menu.toString() + "Choose a menu item:", (selection) -> {
      return menu.getFood(selection);
    });
  }

  // (4)
  private void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
    System.out.println("Processing payment...");

    int remainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();
    customer.setMoney(remainingMoney);
    System.out.printf("You purchased %s. The total goes to $%d\n", shoppingBag.toString(),
        shoppingBag.getTotalPrice());
    System.out.printf("Your remaining money: $%d\n", customer.getMoney());
    System.out.println("Thank you and enjoy your food!");
  }

  // Main method to simulate the takeout process
  private void takeoutPrompt() {
    ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
    int customerMoneyLeft = customer.getMoney();

    while (isStillOrderingFood()) {
      System.out.printf("You have $%s left to spend\n", customerMoneyLeft);
      Food selectedFood = getMenuSelection();
      if (customerMoneyLeft >= selectedFood.getPrice()) {
        shoppingBag.addItem(selectedFood);
        System.out.printf("Added %s to your shopping bag\n", selectedFood.getName());
        customerMoneyLeft -= selectedFood.getPrice();
      } else {
        System.out.println("Oops! Looks like you don't have enough for that. Choose another item or checkout");
      }
    }
    checkoutCustomer(shoppingBag);
  }

  public void startTakeOutSimulator() {
    while (shouldSimulate()) {
      System.out.printf("Hello %s, welcome to my restaurant!\n", customer.getName());
      takeoutPrompt();
    }
  }
}
