package trainingJavaPart2.entranceexams;

import java.util.Objects;

public class Exam {

    private String nameExam;
    private String task;

    public Exam(String nameExam, String task) {
        this.nameExam = nameExam;
        this.task = task;
    }

    public String getNameExam() {
        return nameExam;
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        return Objects.equals(nameExam, exam.nameExam);
    }

    @Override
    public int hashCode() {
        return nameExam != null ? nameExam.hashCode() : 0;
    }

}
