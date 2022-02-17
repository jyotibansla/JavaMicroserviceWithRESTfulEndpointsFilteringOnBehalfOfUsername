package com.example.demo.ProjectController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ProjectEntity.Project;
import com.example.demo.ProjectException.ResourceNotFound;
import com.example.demo.ProjectRepository.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
// Get All User Information
	@GetMapping
	public List<Project> getAllProjects(){
		return this.projectRepository.findAll();
	}
	
// Get User by id	
	@GetMapping("/{id}")
	public Project getUserByName(@PathVariable ("id") long projectId ) {
		 return this.projectRepository.findById(projectId)
					.orElseThrow(() -> new ResourceNotFound ("User Not Found" +projectId));
	}
	
	
// Get User by name
	@RequestMapping("/proname/{username}")
	public List<Project> getUserByUsername(@PathVariable String username){
		return projectRepository.findByUsername(username);
	}
	
	
	
	
// Create User in Database
	
	@PostMapping
	public Project CreateProject(@RequestBody Project project) {
		
		return this.projectRepository.save(project);
	}
	
// Update User if any
	@PutMapping("/{id}")
	public Project UpdateProject(@RequestBody Project project, @PathVariable ("id") long projectId) {
		Project excitinguser = this.projectRepository.findById(projectId)
		.orElseThrow(() -> new ResourceNotFound ("User Not Found" +projectId));
		excitinguser.setUserName(project.getUserName());
		excitinguser.setProjectName(project.getProjectName());
		excitinguser.setProjectTask(project.getProjectTask());
		return this.projectRepository.save(excitinguser);
	}
	
// Delete User if any
	@DeleteMapping("/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable ("id") long projectId) {
		Project excitinguser = this.projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFound ("User Not Found" +projectId));
		this.projectRepository.delete(excitinguser);
		return ResponseEntity.ok().build();
		
	}   
}
