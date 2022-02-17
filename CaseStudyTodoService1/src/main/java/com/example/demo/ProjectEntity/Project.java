package com.example.demo.ProjectEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                        // To Make 'UserEntity' Class as JPA Entity
@Table(name = "projects")                        // To Provide Table Details
public class Project {
	
	@Id                // To Set id as primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "ProjectName")
	private String projectname;
	
	@Column(name = "ProjectTask")
	private String projecttask;
	
	
	
// Create Constructor
	public Project () {
		
	}
	public Project(String projectname, String projecttask,String username) {
		super();
		this.projectname = projectname;
		this.projecttask = projecttask;
		this.username = username;
		
	}
	
// Create Getter and Setter to access Private Fields
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectname;
	}
	public void setProjectName(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectTask() {
		return projecttask;
	}
	public void setProjectTask(String projecttask) {
		this.projecttask = projecttask;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	
	
	

}


