public interface PricedItem<T extends Number> {
  T getPrice(); // returning Integer, Double, etc.
  void setPrice(T price); // accepting Integer, Double, etc as parameters
  String getName();
}
