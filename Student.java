package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    Double[] testScores;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
        addTestScoresToExamScoresList(testScores);
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamTaken() {
        return examScores.size();
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

public void addTestScoresToExamScoresList(Double[] testScores){
        for (int x = 0; x < testScores.length;x++){
            examScores.add(testScores[x]);
        }
}
    public String getExamScores() {

        String finalString ="";
        String examnum = "";
         for(int x = 0; x < examScores.size(); x++) {
             int y = x+1;
             examnum = "\n " + "\t"+"\t" + "Exam " + y  + "-> " + examScores.get(x);
              finalString += examnum;
         }
        return "Exam Scores:" +
                finalString;
    }
    public String getExamScores1() {
        String finalString ="";
        String examnum = "";
        for(int x = 0; x < testScores.length; x++) {
            int y = x+1;
            examnum = "\n " + "\t"+"\t" + "Exam " + y  + "-> " + testScores[x];
            finalString += examnum;
        }
        return "Exam Scores:" +
                finalString;
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }
    public void setExamScore(int examNumber, double newScore){


       examScores.add(examNumber - 1, newScore);

    }

    public double getAverageExamScore(){
        int sum = 0;
        int mean = 0;
        for (Double x: examScores){
            sum += x;
            mean = sum / examScores.size();

        }
        return mean;
    }

    @Override
    public String toString() {


        return "\n" + "Student Name: " + firstName +" "+ lastName + '\n' +
                "> "+ "Average Score: "+ getAverageExamScore() + "\n" +
                "> " + getExamScores();
    }
}
