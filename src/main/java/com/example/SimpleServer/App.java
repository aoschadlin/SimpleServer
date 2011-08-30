package com.example.SimpleServer;

import org.restlet.Component;
import org.restlet.data.Protocol;
import com.example.SimpleServer.app.*;

public class App 
{
    public static void main( String[] args )
    {
		System.out.println("Starting server");

		try {
			// Create a new Component.  
		    Component component = new Component();  
		  
		    // Add a new HTTP server listening on port 4080.  
		    component.getServers().add(Protocol.HTTP, 4080);  
		  
		    // Attach the sample application.  
		    component.getDefaultHost().attach("/main", new SimpleServerApp());  
		  
			// Start the component.  
		    component.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
