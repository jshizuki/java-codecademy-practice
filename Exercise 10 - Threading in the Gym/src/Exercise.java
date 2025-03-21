import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exercise {
  private final MachineType machine;
  private final Map<Weight, Integer> weight;
  private final int duration;

  public Exercise() {
    this.machine = MachineType.getRandomEquipment();

    Map<Weight, Integer> weightSet = new HashMap<>();
    weightSet.put(Weight.SMALL_5LBS, 0);
    weightSet.put(Weight.MEDIUM_10LBS, 0);
    weightSet.put(Weight.LARGE_25LBS, 0);

    for (int i = 0; i < 10; i++) {
      Weight weight = Weight.getRandomWeight();
      int rand = new Random().nextInt(4);
      if (rand < 3) {
        weightSet.replace(weight, weightSet.get(weight) + 1);
      }
    }

    this.weight = weightSet;
    this.duration = 1000 + new Random().nextInt(2000);
  }

  public int getDuration() {
    return this.duration;
  }

  @Override
  public String toString() {
    int totalWeight = this.weight.get(Weight.SMALL_5LBS) * 5 + this.weight.get(Weight.MEDIUM_10LBS) * 10
        + this.weight.get(Weight.LARGE_25LBS) * 25;

    String weightsMessage = String
        .format("%d lbs of total weight consisting of %d x 5 lbs weights, %d x 10 lbs weight and %d of 25 lbs weights",
            totalWeight, this.weight.get(Weight.SMALL_5LBS), this.weight.get(Weight.MEDIUM_10LBS),
            this.weight.get(Weight.LARGE_25LBS));

    return String.format("%s with %s\n", this.machine.machineName, weightsMessage);
  }
}
