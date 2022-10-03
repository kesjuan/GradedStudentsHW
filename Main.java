package io.zipcoder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double[] testScores = {100.0, 10.0};
        Double[] testScores1 = {100.0, 25.0};
        Double[] testScores2 = {100.0,80.0};
        Double[] testScores3 = {100.0, 100.0};
        Double[] testScores4 = {75.0, 85.0};
        Double[] testScores5 = {90.0,80.0};
        Double[] testScores6 = {110.0,65.0};

        Student student = new Student("jerry", "roane",testScores );
        Student student1 = new Student("perry", "patron",testScores1 );
        Student student3 = new Student("merry", "xmas", testScores2);
        Student student4 = new Student("harry", "smith",testScores3 );
        Student student5 = new Student("terry", "joane",testScores4 );
        Student student6 = new Student("carry", "groane",testScores5 );
        Student student7 = new Student("fitzgerry", "sloane",testScores6 );
        student.addTestScoresToExamScoresList(testScores);
        student1.addTestScoresToExamScoresList(testScores1);
        student3.addTestScoresToExamScoresList(testScores2);

       // student.addExamScore(100);
       // student.setExamScore(1,150);
       // System.out.println(student.getExamScores());
       // System.out.println(student.getAverageExamScore());



        Student[] students = {student, student1,student4,student5,student6,student7};
        Classroom classroom = new Classroom(students);
        // System.out.println(classroom.getAverageExamScoreForClass());

         Classroom classroom1 = new Classroom(1);


         classroom1.addStudent(student3);
        //System.out.println(Arrays.toString(classroom1.getStudents()));
        classroom.addStudent(student3);

         //classroom.removeStudent("perry", "patron");
       // System.out.println(Arrays.toString(classroom.getStudents()));
          // classroom.getStudentsByScore();
        System.out.println(classroom.getGradeBook());

     //   System.out.println(classroom1.toString());
        //System.out.println(student.toString());




    }
}
