package io.zipcoder;

import jdk.jfr.Percentage;
import org.hamcrest.internal.ArrayIterator;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom {
    Student[] students;

    public Classroom(int maxNumberOfStudents) {
        ArrayList<Student> studentArrayList = new ArrayList<>(maxNumberOfStudents);
         this.students  = new Student[maxNumberOfStudents];
        }



    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom() {
        Student[] students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }
    public double getAverageExamScoreForClass(){
        int sum = 0;
        int mean = 0;
        for(int x = 0; x < students.length; x++){
            sum += (int) students[x].getAverageExamScore();

        }
        mean = sum / students.length;
        return mean;
    }
    public void addStudent(Student student) {
        if (getStudents().equals(null)){
            this.students[0] = student;
        }
        else {
            Student[] tempArray = new Student[this.students.length + 1];
            for (int x = 0; x < this.students.length; x++) {
                tempArray[x] = this.students[x];
            }

            tempArray[tempArray.length - 1] = student;
            students = tempArray;
        }
    }

    public void removeStudent(String firstName, String lastName){

        for (int x = 0; x < students.length; x++) {
            if (students[x].getFirstName() == firstName && students[x].getLastName() == lastName ){
                students[x].setFirstName(null);
                students[x].setLastName(null);
                students[x].setExamScores(new ArrayList<>());

                break;
            }

        }
    }
    public void getStudentsByScore(){
        List<Student> studentList = Arrays.asList(students);

    Comparator scoreComperator = new ScoreComperator();
    Collections.sort(studentList, scoreComperator);
        for (Student x: students){
            System.out.println(x);
        }
    }

    public Character getPercentile(Student student){

        List<Student> studentList = Arrays.asList(students);
        Comparator percintileHelper = new ScoreComperator();
        Collections.sort(studentList,percintileHelper);

        Character finalGrade = 'o';

        for (int i = 0; i < studentList.size(); i++){
            if(student == studentList.get(i)) {
                float y = i + 1;
                float numberOfValuesbelow = studentList.size() - y;
                float percentile = (numberOfValuesbelow / (float) studentList.size()) * 100.0f;
                int finalRank = 100 - (int) percentile;
               // System.out.println(finalRank + studentList.get(i).getFirstName());
                if (finalRank <= 10){
                    finalGrade = 'A'; break;
                }
                if (finalRank >= 11 && finalRank <= 29 ){
                    finalGrade = 'B'; break;
                }
                if (finalRank >= 30 && finalRank <= 50 ){
                    finalGrade = 'C'; break;
                }
                if(finalRank >= 51 && finalRank <= 89){
                    finalGrade = 'D'; break;
                }
                else{ finalGrade = 'F'; break;}



            }

        }

        // percentile = (number of values below x / total number of values) * 100
            return finalGrade;
    }
    public Map getGradeBook(){
        Map<String,Character> gradeBook = new TreeMap<>();//Map<>();


        for(Student x: students) {

            gradeBook.put(x.getFirstName(), getPercentile(x));
        }
        return gradeBook;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
}
