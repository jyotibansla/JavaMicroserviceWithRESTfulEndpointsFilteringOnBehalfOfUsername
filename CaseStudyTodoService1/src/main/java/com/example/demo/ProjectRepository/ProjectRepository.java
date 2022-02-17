package com.example.demo.ProjectRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.ProjectEntity.Project;

@Repository
public interface ProjectRepository extends JpaRepository <Project, String> {

	public List<Project> findByUsername(String username);
//	public List<User> findByLastname(String  lastname);

	public Optional<Project> findById(long projectId);
	
}
