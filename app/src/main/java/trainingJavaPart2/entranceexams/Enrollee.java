package trainingJavaPart2.entranceexams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enrollee {

    private final List<Answer> answers;
    private String name;
    private String facultyName;
    private double avg;
    private boolean enrolled;

    public Enrollee(String name, String facultyName) {
        this.name = name;
        this.facultyName = facultyName;
        answers = new ArrayList<>();
        enrolled = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void refreshAvg() {
        avg = (double) answers.stream().mapToInt(Answer::getScore).sum() / (double) answers.size();
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    public double getAvg() {
        return avg;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Enrollee enrollee = (Enrollee) obj;

        return (Objects.equals(name, enrollee.name)) && (Objects.equals(facultyName, enrollee.facultyName));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

}
