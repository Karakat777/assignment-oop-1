package database;

import models.Course;
import java.util.List;

public interface ICourseDAO {
    List<Course> getAllCourses();
    boolean addCourse(Course course);
    boolean deleteCourse(String code);
}