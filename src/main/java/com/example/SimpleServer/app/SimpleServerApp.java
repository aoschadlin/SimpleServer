package com.example.SimpleServer.app;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.example.SimpleServer.resource.UserResource;

public class SimpleServerApp extends Application {
    /** 
     * Creates a root Restlet that will receive all incoming calls. 
     */  
    @Override  
    public synchronized Restlet createInboundRoot() {  
        // Create a router Restlet that routes each call to a  
        // new instance of ReceiptResource.  
        Router router = new Router(getContext());  
  
        // Defines only one route  
        router.attach("/users", UserResource.class);
        router.attach("/users/{id}", UserResource.class);
  
        return router;  
    }


}
