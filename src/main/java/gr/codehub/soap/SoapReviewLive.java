package gr.codehub.soap;

import gr.codehub.soap.service.FastgramService;
import gr.codehub.soap.service.FastgramServiceImpl;
import jakarta.xml.ws.Endpoint;

public class SoapReviewLive {

    public static void main(String[] args) {
        System.out.println("Starting web service");
        FastgramService fs = new FastgramServiceImpl();
        Endpoint.publish("http://localhost:7890/FastgramService", fs);
        System.out.println("Application ended.");
    }
}
