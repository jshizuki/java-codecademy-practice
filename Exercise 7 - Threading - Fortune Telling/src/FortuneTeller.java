import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FortuneTeller {
  public static void main(String[] args) {
    List<Question> questions = new ArrayList<>();

    questions.add(new Question("Will I win the lottery?", Question.Difficulty.EASY));
    questions.add(new Question("Will I get a promotion?", Question.Difficulty.MEDIUM));
    questions.add(new Question("Will I find true love?", Question.Difficulty.HARD));
    questions.add(new Question("Will I be happy?", Question.Difficulty.EASY));
    questions.add(new Question("Will I be rich?", Question.Difficulty.MEDIUM));
    questions.add(new Question("Will I be famous?", Question.Difficulty.HARD));

    CrystalBall crystalBall = new CrystalBall();

    List<Thread> threads = questions.stream().map(question -> {
      return new Thread(() -> {
        crystalBall.ask(question);
      });
    }).collect(Collectors.toList());

    Thread supervisor = createSupervisor(threads);

    threads.stream().forEach(thread -> thread.start());
    supervisor.start();
  }

  public static Thread createSupervisor(List<Thread> threads) {
    Thread supervisor = new Thread(() -> {
      while (true) {

        List<String> runningThreads = threads.stream().filter(thread -> {
          return thread.isAlive();
        }).map(thread -> {
          return thread.getName();
        }).collect(Collectors.toList());

        System.out.println(Thread.currentThread().getName() + " - currently running threads: " + runningThreads);

        if (runningThreads.size() == 0) {
          break;
        }

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println(e);
        }
      }

      System.out.println(Thread.currentThread().getName() + " - all threads completed");

    });
    supervisor.setName("supervisor");
    return supervisor;
  }
}
