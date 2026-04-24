package com.university.dao;

import com.university.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM courses";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setName(rs.getString("name"));
                c.setInstructor(rs.getString("instructor"));
                c.setCredits(rs.getInt("credits"));
                list.add(c);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return list;
    }

    public void registerCourse(int studentId, int courseId) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO registrations (student_id, course_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public boolean isAlreadyRegistered(int studentId, int courseId) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM registrations WHERE student_id=? AND course_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return false;
    }

    public List<Course> getMyCourses(int studentId) {

        List<Course> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {

            String sql = """
                        SELECT c.* 
                        FROM courses c
                        JOIN registrations r ON c.course_id = r.course_id
                        WHERE r.student_id = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setName(rs.getString("name"));
                c.setInstructor(rs.getString("instructor"));
                c.setCredits(rs.getInt("credits"));
                list.add(c);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return list;
    }
}