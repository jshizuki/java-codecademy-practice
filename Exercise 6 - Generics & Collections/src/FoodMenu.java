import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
  private List<Food> menu;

  public FoodMenu() {
    menu = new ArrayList<>();

    menu.add(new Food("Yakisoba", "A noodle dish", 10));
    menu.add(new Food("Sushi", "A Japanese dish", 15));
    menu.add(new Food("Ramen", "A noodle soup", 12));
  }

  public Food getFood(int customerChoice) throws IndexOutOfBoundsException {
    try {
      return menu.get(customerChoice - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public Food getLowestCostFood() {
    int lowestCost = Integer.MAX_VALUE;
    Food lowestCostFood = menu.get(0);
    for (Food food : menu) {
      int priceOfFoodItem = food.getPrice();
      if (priceOfFoodItem < lowestCost) {
        lowestCost = priceOfFoodItem;
        lowestCostFood = food;
      }
    }
    return lowestCostFood;
  }

  @Override // Displaying menu - iterate menu list and print each item
  // 1. Enjoy Tacos: Yummy steak tacos    Cost: $15
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Food food : menu) {
      int index = menu.indexOf(food);
      sb.append(String.format("%d. %s", index + 1, food.toString()));
    }
    return sb.toString();
  }
}
