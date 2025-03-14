import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
      Gym anytimeFitness = new Gym(5, new HashMap<>() {
        {
          put(MachineType.LEGPRESSMACHINE, 5);
          put(MachineType.BARBELL, 5);
          put(MachineType.SQUATMACHINE, 5);
          put(MachineType.LEGEXTENSIONMACHINE, 5);
          put(MachineType.LEGCURLMACHINE, 5);
          put(MachineType.LATPULLDOWNMACHINE, 5);
          put(MachineType.PECDECKMACHINE, 5);
          put(MachineType.CABLECROSSOVERMACHINE, 5);
        }
      });

      anytimeFitness.openForToday();
    }
}
