import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Member {
  private final int id;

  public Member(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  public List<Exercise> generateRoutine() {
    return IntStream.range(0, 6).mapToObj(_i -> new Exercise()).collect(Collectors.toList());
  }

  public void performRoutine() {
    List<Exercise> routine = generateRoutine();

    routine.forEach(exercise -> {
      System.out.printf("Gym member %d is performing exercise %s", this.getId(), exercise);

      try {
        Thread.sleep(exercise.getDuration());
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    });
  }
}
