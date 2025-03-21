import java.util.Random;

public class CrystalBall {
  // private Question question;

  // public CrystalBall(Question question) {
  //   this.question = question;
  // }

  private int getSleepTimeInMs(Question.Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return 1000;
      case MEDIUM:
        return 2000;
      case HARD:
        return 6000;
      default:
        return 0;
    }
  }

  private void think(Question question) {
    try {
      System.out.println("Thinking...");
      Thread.sleep(this.getSleepTimeInMs(question.getDifficulty()));
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("Done!");
  }

  private String answer() {
    String[] answers = {
      "Yes",
      "No",
      "Maybe",
      "I don't know"
    };
    return answers[new Random().nextInt(answers.length)];
  }

  public void ask(Question question) {
    // get question, think time depending on difficulty, get answer
    String theQuestion = question.getQuestion();
    System.out.println("You asked: " + theQuestion);
    this.think(question);
    System.out.printf("You asked %s and the answer is %s\n", theQuestion, this.answer());
  }

  // public void run() {
  //   this.ask(this.question);
  // }
}
