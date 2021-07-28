package trainingJava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StudentsTask {


    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */

    public static void main(String[] args) {

        // Студенты
        Student ivan = new Student("Иванов","Иван","Ивановчи",LocalDate.of(1992, 12, 2),2,202,4,5,5,4,5);
        Student oleg = new Student("Коржев","Олег","Олегович",LocalDate.of(1991, 10, 22),3,203,5,4,5,5,5);
        Student kirill = new Student("Токачев","Кирилл","Кириллович",LocalDate.of(1992, 2, 12),2,202,5,5,5,5,5);
        Student vadim = new Student("Каламбет","Вадим","Вадимович",LocalDate.of(1993, 1, 1),1,201,5,5,5,4,5);
        Student roman = new Student("Петров","Роман","Романович",LocalDate.of(1994, 6, 26),4,204,5,5,5,4,5);
        Student alex = new Student("Макаренко","Алексей","Алексеевич",LocalDate.of(1994, 4, 18),4,204,5,5,5,4,5);
        Student sergey = new Student("Абрамов","Сергей","Сергеевич",LocalDate.of(1994, 8, 9),4,204,5,5,5,4,5);


        // Заполняем список студентов
        ArrayList<Student> students = new ArrayList();
        students.add(ivan);
        students.add(oleg);
        students.add(kirill);
        students.add(vadim);
        students.add(roman);
        students.add(alex);
        students.add(sergey);



    }


    /*Упорядочите студентов по курсу, причем студенты одного курса располагались
    в алфавитном порядке*/
    public static List<Student> curseSort(List<Student> inputList){

        inputList.sort(Comparator.comparing(Student::getLastName));
        inputList.sort(Comparator.comparing(Student::getCourse));

        return inputList;
    }




    // Данные метод принимает список студентов и сортирует его по заданому номеру группы
    public static List<Student> groupSort (List<Student> inputList , int groupNumber){

        ArrayList<Student> group = new ArrayList();

        for (int i = 0; i < inputList.size(); i++){
            if (inputList.get(i).getGroupNumber() == groupNumber){
                group.add(inputList.get(i));
            }
        }

        return group;
    }

    // Нахождения стредннего бала для каждой группы по каждому предмету
    public static String averageScoreSort(List<Student> inputList){

        String result = "Стредние баллы группы по предметам" + "\n";

        int[] algebra = new int[inputList.size()], geometry = new int[inputList.size()], physics = new int[inputList.size()],
                programing = new int[inputList.size()], robotoTech = new int[inputList.size()];

        int algebraSum, geometrySum, physicsSum, programingSum, robotoTechSum;

        for(int i = 0; i < inputList.size(); i++){
            algebra[i] = inputList.get(i).getAlgebra();
            geometry[i] = inputList.get(i).getGeometry();
            physics[i] = inputList.get(i).getPhysics();
            programing[i] = inputList.get(i).getPrograming();
            robotoTech[i] = inputList.get(i).getRobotoTech();
        }

        algebraSum = IntStream.of(algebra).sum() / algebra.length;
        geometrySum = IntStream.of(geometry).sum() / geometry.length;
        physicsSum = IntStream.of(physics).sum() / physics.length;
        programingSum = IntStream.of(programing).sum() / programing.length;
        robotoTechSum = IntStream.of(robotoTech).sum() / robotoTech.length;

        return result + "Алгебра: " + algebraSum + " Геометрия: " + geometrySum + " Физика: " + physicsSum + " Программиование: " + programingSum +
                " Робототехника: " + robotoTechSum;
    }


    //Определите самого старшего студента и самого младшего студентов.

    public static String sortByAge (List<Student> inputList){


        LocalDate localDateYong = LocalDate.now();
        DateTimeFormatter formatterOld = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDateOld = LocalDate.now();
        DateTimeFormatter formatterYong = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        for (int i = 0; i < inputList.size(); i++) {
            localDateYong = inputList.get(0).getYearOfBirth();
            if (inputList.get(i).getYearOfBirth().isAfter(localDateYong)) {
                localDateYong = inputList.get(i).getYearOfBirth();
            }
        }

        for (int i = 0; i < inputList.size(); i++) {
            localDateOld = inputList.get(0).getYearOfBirth();
            if (inputList.get(i).getYearOfBirth().isBefore(localDateOld)) {
                localDateOld = inputList.get(i).getYearOfBirth();
            }
        }

        return "Самый старший студент: " + localDateOld + ". Самый младший студент: " + localDateYong;

    }

    // Нахождение для каждой группы лучшего студента по успеваемости

    public static String beastStudents (List<Student> inputList){

        Student student201 = new Student();
        Student student202 = new Student();
        Student student203 = new Student();
        Student student204 = new Student();


        ArrayList<Student> group201 = new ArrayList();
        ArrayList<Student> group202 = new ArrayList();
        ArrayList<Student> group203 = new ArrayList();
        ArrayList<Student> group204 = new ArrayList();

        int groupNumber201 = 201, groupNumber202 = 202, groupNumber203 = 203,  groupNumber204 = 204;



        for (int i = 0; i < inputList.size(); i++){
            if (inputList.get(i).getGroupNumber() == groupNumber201){
                group201.add(inputList.get(i));
            } else if (inputList.get(i).getGroupNumber() == groupNumber202){
                group202.add(inputList.get(i));
            } else if (inputList.get(i).getGroupNumber() == groupNumber203){
                group203.add(inputList.get(i));
            } else if (inputList.get(i).getGroupNumber() == groupNumber204){
                group204.add(inputList.get(i));
            }
        }

        for(int i = 0; i < group201.size(); i++){
            Student buff = group201.get(0);
            if(buff.getMidlScore(buff.getAlgebra(), buff.getGeometry(), buff.getPhysics(), buff.getPrograming(), buff.getRobotoTech()) <
                    group201.get(i).getMidlScore(group201.get(i).getAlgebra(), group201.get(i).getGeometry(), group201.get(i).getPhysics(), group201.get(i).getPrograming(), group201.get(i).getRobotoTech())) {
                student201 = group201.get(i);
            } else {
                student201 = buff;
            }
        }

        for(int i = 0; i < group202.size(); i++){
            Student buff = group202.get(0);
            if(buff.getMidlScore(buff.getAlgebra(), buff.getGeometry(), buff.getPhysics(), buff.getPrograming(), buff.getRobotoTech()) <
                    group202.get(i).getMidlScore(group202.get(i).getAlgebra(), group202.get(i).getGeometry(), group202.get(i).getPhysics(), group202.get(i).getPrograming(), group202.get(i).getRobotoTech())) {
                student202 = group202.get(i);
            } else {
                student202 = buff;
            }
        }


        for(int i = 0; i < group203.size(); i++){
            Student buff = group203.get(0);
            if(buff.getMidlScore(buff.getAlgebra(), buff.getGeometry(), buff.getPhysics(), buff.getPrograming(), buff.getRobotoTech()) <
                    group203.get(i).getMidlScore(group203.get(i).getAlgebra(), group203.get(i).getGeometry(), group203.get(i).getPhysics(), group203.get(i).getPrograming(), group203.get(i).getRobotoTech())) {
                student203 = group203.get(i);
            } else {
                student203 = buff;
            }
        }


        for(int i = 0; i < group204.size(); i++){
            Student buff = group204.get(0);
            if(buff.getMidlScore(buff.getAlgebra(), buff.getGeometry(), buff.getPhysics(), buff.getPrograming(), buff.getRobotoTech()) <
                    group204.get(i).getMidlScore(group204.get(i).getAlgebra(), group204.get(i).getGeometry(), group204.get(i).getPhysics(), group204.get(i).getPrograming(), group204.get(i).getRobotoTech())) {
                student204 = group204.get(i);
            } else {
                student204 = buff;
            }
        }

        return "Лучший студент в группе 201: " + student201.getFirstName() + " " + student201.getLastName() + "\n" +
                "Лучший студент в группе 202: " + student202.getFirstName() + " " + student202.getLastName() + "\n" +
                "Лучший студент в группе 203: " + student203.getFirstName() + " " + student203.getLastName() + "\n" +
                "Лучший студент в группе 204: " + student204.getFirstName() + " " + student204.getLastName();
    }

}


// Создание класса студнта
class Student implements Comparable<Student>{

    String firstName;
    String lastName;
    String middleName;
    LocalDate yearOfBirth;
    int course;
    int groupNumber;
    int algebra, geometry, physics, programing, robotoTech;

    public Student(){}

    public Student(String lastName, String firstName, String middleName, LocalDate yearOfBirth, int course,
                   int groupNumber, int algebra, int geometry, int physics, int programing, int robotoTech)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.yearOfBirth = yearOfBirth;
        this.course = course;
        this.groupNumber = groupNumber;
        this.algebra = algebra;
        this.geometry = geometry;
        this.physics = physics;
        this.programing = programing;
        this.robotoTech = robotoTech;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getAlgebra() {
        return algebra;
    }

    public void setAlgebra(int algebra) {
        this.algebra = algebra;
    }

    public int getGeometry() {
        return geometry;
    }

    public void setGeometry(int geometry) {
        this.geometry = geometry;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getPrograming() {
        return programing;
    }

    public void setPrograming(int programing) {
        this.programing = programing;
    }

    public int getRobotoTech() {
        return robotoTech;
    }

    public void setRobotoTech(int robotoTech) {
        this.robotoTech = robotoTech;
    }

    public double getMidlScore(int algebra, int geometry, int physics, int programing, int robotoTech){
        this.algebra = algebra;
        this.geometry = geometry;
        this.physics = physics;
        this.programing = programing;
        this.robotoTech = robotoTech;

        double algebraD = algebra;
        double geometryD = geometry;
        double physicsD = physics;
        double programingD = programing;
        double robotoTechD = robotoTech;



        double midlScope = (algebraD+geometryD+physicsD+programingD+robotoTechD)/5.0;
        return midlScope;
    }

    @Override
    public int compareTo(Student s) {
        return lastName.compareTo(s.getLastName());
    }

}
