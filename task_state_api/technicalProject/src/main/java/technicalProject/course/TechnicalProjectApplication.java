package technicalProject.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import technicalProject.course.entity.Course;
import technicalProject.course.service.CourseService;

@SpringBootApplication
public class TechnicalProjectApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(TechnicalProjectApplication.class, args);
		
		
		
	}

}
