package technicalProject.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technicalProject.course.dao.CourseRepository;
import technicalProject.course.entity.Course;

@Service
public class CourseServiceImplmentation implements CourseService {
	
	@Autowired
	EntityManager entityManager;
	
	private CourseRepository courseRepository;
	
	Map<String, Integer> maper;
	
	
	public CourseServiceImplmentation(CourseRepository theCourseRepository) {
		
		
		
		
		this.courseRepository=theCourseRepository;
		
		maper=new HashMap<>();
		
		maper.put("draft", 1);
		maper.put("active", 2);
		maper.put("done", 3);
		maper.put("archived", 4);
		
	}


	@Override
	public List<Course> getAll() {
		
		return this.courseRepository.findAll();
	}


	@Override
	public Course getById(int id) {
		
		Course tempCourse=null;
		
		Optional<Course> result=this.courseRepository.findById(id);
		
		if(result.isPresent())
			return result.get();
		
		else {
			throw new RuntimeException("Course not found with this id -_- ");
		}
	}


	@Override
	public boolean deleteById(int id) {
		
		try {
			this.courseRepository.deleteById(id);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
		
		
		
	}


	@Override
	@Transactional
	public boolean update(Course theCourse) {
		
		Course savedCourse=this.getById(theCourse.getId());
		
		int savedCourseIndex =maper.get(savedCourse.getState().toLowerCase());
		
		int camedCourseIndex =maper.get(theCourse.getState().toLowerCase());
		
		if((camedCourseIndex-savedCourseIndex)==1) {
			
			Session curentSession= this.entityManager.unwrap(Session.class);
			
			savedCourse.setState(theCourse.getState());
			curentSession.saveOrUpdate(savedCourse);
			return true;
		}
		
		
		
		return false;
	}


	@Override
	public boolean save(Course course) {
		try {
			this.courseRepository.save(course);
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
		
		
	}
	
	

}
