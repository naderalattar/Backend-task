package technicalProject.course.service;

import java.util.List;

import technicalProject.course.entity.Course;

public interface CourseService {
	
	public List<Course> getAll();
	
	public Course getById(int id);
	
	public boolean save(Course course);
	
	public boolean deleteById(int id);
	
	public boolean update(Course theCourse);
	

}
