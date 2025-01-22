-- V4__crear_tabla_user_courses.sql
CREATE TABLE user_courses (
      user_id CHAR(36) NOT NULL,
      course_id CHAR(36) NOT NULL,
      PRIMARY KEY (user_id, course_id),
      FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
      FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE ON UPDATE CASCADE
);
