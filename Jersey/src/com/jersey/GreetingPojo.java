package com.jersey;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class GreetingPojo 
{
	private String greeting;
	private String name;
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
