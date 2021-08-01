package trainingJavaPart2.entranceexams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Faculty {

    private String facultyName;
    private String teacherUsername;
    private List<Exam> exams;
    private List<Enrollee> enrollees;
    private List<Faculty> faculties;

    public Faculty(String facultyName, String teacherUsername) {
        this.facultyName = facultyName;
        this.teacherUsername = teacherUsername;
        exams = new ArrayList<>();
        enrollees = new ArrayList<>();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void enroll() {
        enrollees.forEach(enrollee -> enrollee.setEnrolled(false));
        enrollees.sort(Comparator.comparingDouble(Enrollee::getAvg).reversed());
    }

    public List<Enrollee> getEnrollees() {
        return enrollees;
    }

    public void setEnrollees(List<Enrollee> enrollees) {
        this.enrollees = enrollees;
    }

    public List<Enrollee> getEnrolled() {
        return enrollees.stream().filter(Enrollee::isEnrolled).collect(Collectors.toList());
    }

    public void registerEnrollee(Enrollee enrollee) {
        enrollees.add(enrollee);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return Objects.equals(facultyName, faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return facultyName != null ? facultyName.hashCode() : 0;
    }

}
