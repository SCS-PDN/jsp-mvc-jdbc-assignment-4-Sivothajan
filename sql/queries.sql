USE dbs21513;

-- View all students
SELECT *
FROM students;

-- View all courses
SELECT *
FROM courses;

-- View registrations
SELECT *
FROM registrations;

-- My courses (example for student_id = 1)
SELECT c.*
FROM courses c
         JOIN registrations r
              ON c.course_id = r.course_id
WHERE r.student_id = 1;