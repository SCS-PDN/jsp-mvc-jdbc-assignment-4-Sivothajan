USE dbs21513;
-- Sample students
INSERT INTO students (name, email, password)
VALUES ('Admin User', 'admin@gmail.com',
        '1234'),
       ('John Doe', 'john@example.com', 'pass123');
-- Sample courses
INSERT INTO courses (name, instructor, credits)
VALUES ('Database Systems', 'Dr. Silva',
        3),
       ('Web Development', 'Prof. Perera',
        4),
       ('Algorithms', 'Dr. Fernando', 3);
-- Sample registrations
INSERT INTO registrations (student_id, course_id)
VALUES (1, 1),
       (1, 2);
