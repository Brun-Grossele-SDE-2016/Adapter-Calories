package introsde.adapter.endpoint;

import introsde.adapter.model.Person;
import introsde.adapter.model.Measure;
import introsde.adapter.model.MeasureType;
import introsde.adapter.webservice.Interface;
import introsde.adapter.webservice.Implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

public class Publisher 
{	
	public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException
    {
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        String PORT = "6903";
        String BASE_URL = "/ws/people";
        
        if (HOSTNAME.equals("127.0.0.1"))
        {
            HOSTNAME = "localhost";
        }       

        if (String.valueOf(System.getenv("PORT")) != "null")
        {
            PORT = String.valueOf(System.getenv("PORT"));
        }
        
        String endpointUrl = PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL;
        
        System.out.println("Starting People Service...");
        System.out.println("--> Published. Check out " + endpointUrl + "?wsdl");
        Endpoint.publish(endpointUrl, new Implementation());
    }
}
