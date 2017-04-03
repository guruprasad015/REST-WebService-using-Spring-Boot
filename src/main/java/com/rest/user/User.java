package com.rest.user;

import java.io.Serializable;
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String profession;
	
	public User(int id, String name, String profession){
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getProfession(){
		return profession;
	}
	
	public static long getSerialversionuid()
	{
	    return 1L;
	}
}
