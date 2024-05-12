package com.llp.fluentify.application.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.llp.fluentify.application.model.Chapter;
import com.llp.fluentify.application.model.Course;
import com.llp.fluentify.application.model.Professor;
import com.llp.fluentify.application.model.User;
import com.llp.fluentify.application.model.Wishlist;
import com.llp.fluentify.application.services.ChapterService;
import com.llp.fluentify.application.services.CourseService;
import com.llp.fluentify.application.services.ProfessorService;
import com.llp.fluentify.application.services.WishlistService;

@RestController
public class ProfessorController 
{	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private CourseService courseService;

	
	@GetMapping("/professorlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfessorList() throws Exception
	{
		List<Professor> professors = professorService.getAllProfessors();
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@GetMapping("/courselistbyname/{coursename}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Course>> getCourseListByName(@PathVariable String coursename) throws Exception
	{
		Course courseList = courseService.fetchCourseByCoursename(coursename);
		System.out.println(courseList.getCoursename()+" ");
		List<Course> courselist = new ArrayList<>();
		courselist.add(courseList);
		return new ResponseEntity<List<Course>>(courselist, HttpStatus.OK);
	}
	
	@GetMapping("/professorlistbyemail/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfessorListByEmail(@PathVariable String email) throws Exception
	{
		List<Professor> professors = professorService.getProfessorsByEmail(email);
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@PostMapping("/addProfessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public Professor addNewProfessor(@RequestBody Professor professor) throws Exception
	{
		Professor professorObj = null;
		String newID = getNewID();
		professor.setProfessorid(newID);
		professorObj = professorService.addNewProfessor(professor);
		professorService.updateStatus(professor.getEmail());
		return professorObj;
	}
	
	
	
	@GetMapping("/acceptstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> updateStatus(@PathVariable String email) throws Exception
	{
		professorService.updateStatus(email);
		List<String> al=new ArrayList<>();
		al.add("accepted");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/rejectstatus/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<String>> rejectStatus(@PathVariable String email) throws Exception
	{
		professorService.rejectStatus(email);
		List<String> al=new ArrayList<>();
		al.add("rejected");
		return new ResponseEntity<List<String>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/professorprofileDetails/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Professor>> getProfileDetails(@PathVariable String email) throws Exception
	{
		List<Professor> professors = professorService.fetchProfileByEmail(email);
		return new ResponseEntity<List<Professor>>(professors, HttpStatus.OK);
	}
	
	@PutMapping("/updateprofessor")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Professor> updateProfessorProfile(@RequestBody Professor professor) throws Exception
	{
		Professor professorobj = professorService.updateProfessorProfile(professor);
		return new ResponseEntity<Professor>(professorobj, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalprofessors")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Integer>> getTotalProfessors() throws Exception
	{
		List<Professor> professors = professorService.getAllProfessors();
		List<Integer> professorsCount = new ArrayList<>();
		professorsCount.add(professors.size());
		return new ResponseEntity<List<Integer>>(professorsCount, HttpStatus.OK);
	}
	
	
	public String getNewID()
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
	}
	
}
