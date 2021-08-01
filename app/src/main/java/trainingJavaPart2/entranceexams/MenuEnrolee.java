package trainingJavaPart2.entranceexams;

import java.util.List;
import java.util.Scanner;

public class MenuEnrolee {

    Scanner scanner = new Scanner(System.in);
    private final String name;

    public MenuEnrolee(String name) {
        this.name = name;
    }


    private void passExams(Faculty faculty) {
        Enrollee enrollee = new Enrollee(name, faculty.getFacultyName());
        List<Exam> examList = faculty.getExams();
        System.out.println("Приступим к сдаче экзаменов");
        for (Exam exam : examList) {
            System.out.println("Экзамен по предмету " + exam.getNameExam());
            System.out.println("Задание: " + exam.getTask());
            System.out.println("Введите ваш ответ: ");
            if (scanner.hasNextLine()) {
                String answer = scanner.nextLine();
                enrollee.addAnswer(new Answer(exam.getNameExam(), answer));
            }
            System.out.println("Ответ принят");
        }
        faculty.registerEnrollee(enrollee);
    }

}
