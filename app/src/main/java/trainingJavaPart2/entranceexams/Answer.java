package trainingJavaPart2.entranceexams;

import java.util.Objects;

public class Answer {

    private String examName;
    private String answerText;
    private int score;

    public Answer(String examName, String answerText) {
        this.examName = examName;
        this.answerText = answerText;
        this.score = -1; //not checked by teacher
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Answer answer = (Answer) obj;

        return (Objects.equals(examName, answer.examName)) && (Objects.equals(answerText, answer.answerText));
    }

    @Override
    public int hashCode() {
        int result = examName != null ? examName.hashCode() : 0;
        result = 31 * result + (answerText != null ? answerText.hashCode() : 0);
        return result;
    }

}
