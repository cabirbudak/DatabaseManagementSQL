package org;

public class Students {
    private int students_id;
    private int grade;
    private String students_name;

    public Students(int students_id, String students_name, int grade) {
        this.students_id = students_id;
        this.grade = grade;
        this.students_name = students_name;
    }

    public int getStudents_id() {
        return students_id;
    }

    public int getGrade() {
        return grade;
    }

    public String getStudents_name() {
        return students_name;
    }
}

