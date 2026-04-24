package com.university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public Integer getStudentId(String email, String password) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT student_id FROM students WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("student_id");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return null;
    }

    public boolean register(String name, String email, String password) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO students (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;
    }
}