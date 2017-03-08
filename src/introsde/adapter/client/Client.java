package introsde.adapter.client;

import introsde.adapter.model.Person;
import introsde.adapter.model.Measure;
import introsde.adapter.model.MeasureType;
import introsde.adapter.webservice.People;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	
	public static void main(String[] args) throws Exception 
	{

		 URL url = new URL("http://127.0.1.1:6903/ws/people?wsdl");
	     //1st argument service URI, refer to wsdl document above
	     //2nd argument is service name, refer to wsdl document above
	     QName qname = new QName("http://webservice.soap.assignment.introsde/", "PeopleService");
	     Service service = Service.create(url, qname);
	     People people = service.getPort(People.class);
	     
	     
	     System.out.println("IntroSDE Assignment 3");
	     System.out.println("=================================================");
	     
	     
	     /*  readPersonList() */
	     System.out.println("1: List of perosn");
	     
	     List<Person> pList = people.getPeople();        
	     
	     for(Person p: pList)
	     {
	     	System.out.println("\t--> " + p.getFirstname() + " " + p.getLastname() + " " + p.getBirthdate());
	     }        
	     
	     System.out.println("=================================================");
	}
}
