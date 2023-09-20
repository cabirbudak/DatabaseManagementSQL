package org;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/test";
        String kullaniciAdi = "postgres";
        String parola = "data1234";
        List<Students> studentsList = null;
        Students insertStudents = new Students(106,"Ayse Cakir",50);

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl,kullaniciAdi,parola);

            // INSERT işlemi
            String insertSQL = "INSERT INTO students (students_id, students_name, grade) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSQL);
            insertStatement.setInt(1, insertStudents.getStudents_id());
            insertStatement.setString(2, insertStudents.getStudents_name());
            insertStatement.setInt(3, insertStudents.getGrade());
            int affectedRows = insertStatement.executeUpdate();
            System.out.println("INSERT işlemi sonucunda etkilenen satır sayısı: " + affectedRows);

            // SELECT işlemi
            String selectSQL = "SELECT * FROM students";
            PreparedStatement selectStatement = conn.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            studentsList = new ArrayList<>();
            while (resultSet.next()) {
                // Sonuçları işleme
                int students_id = resultSet.getInt("students_id");
                String students_name = resultSet.getString("students_name");
                int grade = resultSet.getInt("grade");
                Students students = new Students(students_id, students_name, grade);
                studentsList.add(students);
                System.out.println("students_id: " + students_id + ", grade: " + grade);
            }

            // Bağlantıyı kapatma
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(studentsList);
    }
}