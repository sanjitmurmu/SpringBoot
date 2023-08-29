package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

//	List<Course> list;
	
	public CourseServiceImpl() {
//		this.list = new ArrayList<Course>();
//		list.add(new Course(145,"Java Core Course","This course contains basics of java"));
//		list.add(new Course(4554, "Spring Boot Course", "This course contains basics of springboot"));
	}

	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course course = list.stream().filter(x->x.getId() == courseId).findFirst().orElseThrow();
		return courseDao.getReferenceById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list = list.stream().filter(x->x.getId() != courseId).collect(Collectors.toList());
		Course entity = courseDao.getReferenceById(courseId);
		courseDao.delete(entity);
	
	}

	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e-> {
//			if(e.getId() == course.getId()) {
//				e.setDescription(course.getDescription());
//				e.setTitle(course.getTitle());
//			}
//		});
		courseDao.save(course);			
		return course;
	}

}
