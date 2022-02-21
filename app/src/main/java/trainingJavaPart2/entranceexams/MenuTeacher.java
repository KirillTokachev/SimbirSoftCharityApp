package trainingJavaPart2.entranceexams;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MenuTeacher {

    private final String teacherUsername;
    private Institute institute;
    Scanner scanner = new Scanner(System.in);

    public MenuTeacher(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    private void checkStudent(Enrollee enrollee) {
        List<Answer> answers = enrollee.getAnswers();
        System.out.println("Абитуриент: " + enrollee.getName() + ", факультет: " + enrollee.getFacultyName());
        System.out.println("Оцените ответы ");
        Faculty faculty = institute.getByName(enrollee.getFacultyName());
        for (Answer answer : answers) {
            Exam exam = faculty.getExams().stream().filter(Exam -> Objects.equals(Exam.getNameExam(), answer.getExamName())).findFirst().orElse(null);
            assert exam != null;
            System.out.println("Задание по предмету " + exam.getNameExam());
            System.out.println(exam.getTask());
            System.out.println("Ответ поступающего: " + answer.getAnswerText());
            boolean state = false;
            while (!state) {
                System.out.println("Введите оценку: ");
                if (scanner.hasNextInt()) {
                    int k = Integer.parseInt(scanner.nextLine());
                    if (k > 0 && k <= 10) {
                        answer.setScore(k);
                        System.out.println("Ваша оценка принята");
                        state = true;
                    } else {
                        System.out.println("Неправильное значение; оценки находятся в диапазоне от 1 до 10");
                    }
                } else {
                    System.out.println("Вы ввели не число!");
                }
            }
        }
        System.out.println("Оценка абитуриента завершена");
        enrollee.refreshAvg();
    }

}
