package technicalProject.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import technicalProject.course.entity.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
