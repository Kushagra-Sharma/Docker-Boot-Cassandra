package com.example.docker.springcassandradockerdemo.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Student {

	@PrimaryKey
	private int id;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
