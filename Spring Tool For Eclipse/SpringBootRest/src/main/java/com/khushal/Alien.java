package com.khushal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien { 
	private String name;
	private int points;
	@Id
	private int id;
	
	public String getName() {
		return name;
	}
	public void setNamse(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	

}

