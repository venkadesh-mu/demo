package com.jersey;


import java.io.FileInputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.greeting.Example.Greet;
import com.pakulov.jersey.protobuf.internal.MediaTypeExt;

@Path("/protobuf") 
public class Get 
{
	@GET  
	@Produces(MediaTypeExt.APPLICATION_PROTOBUF)  
	public Greet sayHtmlHello() {
		System.out.println("Started");
		Greet.Builder greetBuilder = Greet.newBuilder();
		Greet greet = null;
		String filename = "/home/local/ZOHOCORP/venkat-pt4472/eclipse-workspace/projects/Jersey/src/greeting_protobuf_output";
		try(FileInputStream input = new FileInputStream(filename))
		{
			greet = greetBuilder.mergeFrom(input).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return greet;//Response.status(Response.Status.OK).entity(greet).build();//greet;  
	}


	@GET
	@Path("/getname/{type}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName(@PathParam("type") String type)
	{
		Get g=new Get();
		Greet proto_obj=g.sayHtmlHello();
		if(type.equals("greeting"))
		{
			return proto_obj.getGreeting();
		}
		else
		{
			return proto_obj.getUsername();
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void SignUp(GreetingPojo gp)
	{
		System.out.println("greeting: "+gp.getGreeting()+"\nUsername: "+gp.getName());
	}

}
