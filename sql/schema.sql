-- Create Database
CREATE DATABASE IF NOT EXISTS dbs21513;
USE dbs21513;
-- Students table
CREATE TABLE students
(
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL
);
-- Courses table
CREATE TABLE courses
(
    course_id  INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    instructor VARCHAR(100) NOT NULL,
    credits    INT          NOT NULL
);
-- Registrations table
CREATE TABLE registrations
(
    reg_id     INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id  INT,
    date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES students (student_id),
    FOREIGN KEY (course_id) REFERENCES courses (course_id),
    UNIQUE (student_id, course_id)
    -- prevent duplicates 🔥
);
