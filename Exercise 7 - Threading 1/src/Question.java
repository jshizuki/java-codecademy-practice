public class Question {
  private String question;
  private Difficulty difficulty;

  enum Difficulty {
    EASY, MEDIUM, HARD
  }

  public Question(String question, Difficulty difficulty) {
    this.question = question;
    this.difficulty = difficulty;
  }

  public String getQuestion() {
    return this.question;
  }

  public Difficulty getDifficulty() {
    return this.difficulty;
  }
}
