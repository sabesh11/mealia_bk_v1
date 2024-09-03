package com.example.mealia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Emplyoees")
public class Emplyoee {

	@Id
	@GeneratedValue
	private Long emplyoeeId;
	private String name;
	private String position;
	private String salary;
	
	
	public Long getEmplyoeeId() {
		return emplyoeeId;
	}
	public void setEmplyoeeId(Long emplyoeeId) {
		this.emplyoeeId = emplyoeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
}
