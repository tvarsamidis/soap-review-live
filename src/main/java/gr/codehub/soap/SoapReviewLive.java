package gr.codehub.soap;

import gr.codehub.soap.service.FastgramService;
import gr.codehub.soap.service.FastgramServiceImpl;
import jakarta.xml.ws.Endpoint;

public class SoapReviewLive {

    public static final String SERVICE_URI = "http://localhost:7870/FastgramService";
    public static final String SERVICE_WSDL = SERVICE_URI + "?wsdl";

    public static void main(String[] args) {
        System.out.println("LAST WORKING SOAP VERSION OF APPLICATION");
        System.out.println("Starting web service");
        System.out.println("WSDL is : " + SERVICE_WSDL);
        FastgramService fs = new FastgramServiceImpl();
        Endpoint.publish(SERVICE_URI, fs);
        System.out.println("Application ended.");
    }
}
