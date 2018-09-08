package introsde.endpoint;
import javax.xml.ws.Endpoint;
import introsde.ws.WeatherImpl;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.io.IOException;

//Endpoint publisher
public class WeatherPublisher{
    
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
        String PROTOCOL = "http://";
        String HOSTNAME = InetAddress.getLocalHost().getHostAddress();
        System.out.println(HOSTNAME);
        if (HOSTNAME.equals("127.0.0.1") || HOSTNAME.equals("127.0.1.1"))
        {
            HOSTNAME = "localhost";
        }
        String PORT = "9004";
        String BASE_URL = "/ws/weather";

        // We need this so the App will run on Heroku properly where we got the assigned port
        // in an environment value named PORT
        if(String.valueOf(System.getenv("PORT")) != "null") {
            PORT = String.valueOf(System.getenv("PORT"));
        }

        // Assemble the final endpoint URL
        String endpointUrl = PROTOCOL + HOSTNAME + ":" + PORT + BASE_URL;
        // End publish the endpoint
        Endpoint.publish(endpointUrl, new WeatherImpl());
        
        
        System.out.println("Starting People Service...");
        System.out.println("--> Published at = " + endpointUrl);
    }
}