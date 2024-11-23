package model;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String pass;
	
	//Constructors
	
	public User () {}
	public User (String name, String pass) {
		this.name = name;
		this.pass =pass;
	}
	
	//Getter 
	
	public String getName() { return name;}
	public String getPass() { return pass;}
}
