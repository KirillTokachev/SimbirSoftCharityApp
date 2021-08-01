package trainingJavaPart2.studentTask;

import java.time.LocalDate;

public class Student implements Comparable<Student> {

        private String firstName;
        private String lastName;
        private String middleName;
        private LocalDate yearOfBirth;
        private int course;
        private int groupNumber;
        private int algebra, geometry, physics, programing, robotoTech;

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
        public int compareTo(trainingJavaPart2.studentTask.Student s) {
            return lastName.compareTo(s.getLastName());
        }

    }

