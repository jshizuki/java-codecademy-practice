import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
  private Map<T, Integer> shoppingBag;

  public ShoppingBag() {
    shoppingBag = new HashMap<>();
  }

  public void addItem(T item) {
    if (!shoppingBag.containsKey(item)) {
      shoppingBag.put(item, 1);
    } else {
      shoppingBag.put(item, shoppingBag.get(item) + 1);
    }
  }

  public int getTotalPrice() {
    int totalPrice = 0;
    for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
      int priceOfFoodItem = entry.getKey().getPrice();
      int quantity = entry.getValue();
      totalPrice += priceOfFoodItem * quantity;
    }
    return totalPrice;
  }

  // Show the list of items and quantity in the shopping bag in readable format
  public String toString() {
    StringBuilder sb = new StringBuilder();
    int size = shoppingBag.size();
    int count = 0; // Track position

    for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
      String item = entry.getKey().getName();
      int quantity = entry.getValue();

      if (count == size - 1 && size > 1) {
        sb.append("and "); // Prepend "and" to the last item
      }

      sb.append(quantity).append(" ").append(item);

      if (count < size - 2) {
        sb.append(", "); // Comma for all but the last two items
      } else if (count == size - 2) {
        sb.append(" "); // Space before "and" instead of a comma
      }

      count++;
    }

    return sb.toString();
  }

}
