package com.example.Student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepo;

@RestController
@RequestMapping("/api/student")
public class StudController {

	@Autowired
	private StudentRepo studRepos;
	
	@GetMapping("/get")
	public List<Student> getStudent(){
		return this.studRepos.findAll();
	}
	
	@PostMapping("/create")
	public Student createDetail(@RequestBody Student stud) {
		return this.studRepos.save(stud);
	}
	
	@PutMapping("/update/{id}")
	public Student updateStud(@RequestBody Student stud, @PathVariable(value="id") Integer student) {
	Optional<Student> optional = this.studRepos.findById(student);
	if(optional.isPresent()) 
		 this.studRepos.save(stud);
		 return stud;
	
}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteStud(@RequestBody Student stud, @PathVariable(value="id") Integer student) {
		Optional<Student> optional = this.studRepos.findById(student);
		if(optional.isPresent())
			this.studRepos.deleteById(student);
		return stud;
	}
	
	@GetMapping("/collegeId")
	public ResponseEntity<List<Student>> findByCollegeId(@RequestParam Integer collegeId){
		return  new ResponseEntity<List<Student>> (studRepos.findByCollegeId(collegeId),HttpStatus.OK);
	}
}
