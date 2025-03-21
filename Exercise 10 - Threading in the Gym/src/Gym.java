import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {
  private final int totalGymMembers;
  private Map<MachineType, Integer> availableMachines;

  public Gym(int totalGymMembers, Map<MachineType, Integer> availableMachines) {
    this.totalGymMembers = totalGymMembers;
    this.availableMachines = availableMachines;
  }

  public void openForToday() {
    // gymMemberRoutines will multitask!
    List<Thread> gymMemberRoutines;

    gymMemberRoutines = IntStream.rangeClosed(1, this.totalGymMembers).mapToObj(
        id -> {
          Member member = new Member(id);
          return new Thread(() -> {
            try {
              member.performRoutine();
            } catch (Exception e) {
              System.out.println(e);
            }
          });
        }).collect(Collectors.toList());

    Thread supervisor = createSupervisor(gymMemberRoutines);
    gymMemberRoutines.forEach(Thread::start);
    supervisor.start();
  }

  private Thread createSupervisor(List<Thread> threads) {
    Thread supervisor = new Thread(() -> {
      while (true) {

        List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName)
            .collect(Collectors.toList());

        System.out.printf("%s - %d people still working out\n", Thread.currentThread().getName(),
            runningThreads.size());

        if (runningThreads.isEmpty()) {
          break;
        }

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(e);
        }
      }

      System.out.println("All threads completed - All gym members have finished working out!");
    });
    supervisor.setName("Gym supervisor staff");
    return supervisor;
  }
}
