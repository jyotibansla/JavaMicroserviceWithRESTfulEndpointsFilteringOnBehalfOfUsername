package com.example.demo.ProjectServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ProjectEntity.Project;
import com.example.demo.ProjectRepository.ProjectRepository;

@Service

public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getUserByFirstname(String username){
		return projectRepository.findByUsername(username);
	}
	
/*	public List<User> gertUserByLastname(String lastname) {
		return userRepository.findByLirstname(lastname);
	}
*/
	
	
}

