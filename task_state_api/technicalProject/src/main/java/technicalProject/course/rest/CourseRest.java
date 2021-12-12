package technicalProject.course.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import technicalProject.course.entity.Course;
import technicalProject.course.service.CourseService;

@RestController
public class CourseRest {
	
	
	@Autowired
	CourseService courseService;
	
	private List<String> states;
	
	public CourseRest() {
		states=new ArrayList<String>();
		states.add("draft");
		states.add("active");
		states.add("done");
		states.add("archived");
		
	}
	
	
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<Course> getById(@PathVariable int courseId) {
	  
		try {
			
			Course theCourse= this.courseService.getById(courseId);
			 return new ResponseEntity<Course>(theCourse, HttpStatus.OK);

			
		} catch (RuntimeException ex) {
			
			throw new RuntimeException(ex.getMessage());
		}
		
		
	 		
		
	}
	
	
	
	
	@GetMapping("/course")
	public List<Course> getAll() {
		
	   return this.courseService.getAll();
	}
	
	
	
	@PostMapping("/course")
	public ResponseEntity<String> save(@RequestBody Course theCourse){
		
		if(theCourse.getState().toLowerCase().equals("draft")) {
			theCourse.setId(0);
			
			if(this.courseService.save(theCourse)) {
				return new ResponseEntity<String>("course is saved succesfly", HttpStatus.OK);
			 }
			
	   }
	   else {
		   return new ResponseEntity<String>("state should be draft", HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<String>("course not saved",HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteById(@PathVariable int courseId){
		
		if(this.courseService.deleteById(courseId))
			return new ResponseEntity<String>("course is deleted", HttpStatus.OK);
		
		return new ResponseEntity<String>("course not deleted",HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping("/course")
	public ResponseEntity<String> update(@RequestBody Course theCourse){
		
		
		
		if(this.states.contains(theCourse.getState()) ) {
			
			
			if(this.courseService.update(theCourse)) {
				return new ResponseEntity<String>("course is updated", HttpStatus.OK);
			}
			
		}
		else {
			return new ResponseEntity<String>("this state not predefined ", HttpStatus.BAD_REQUEST);
		}
		
		
		
		return new ResponseEntity<String>("Not allowed", HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
