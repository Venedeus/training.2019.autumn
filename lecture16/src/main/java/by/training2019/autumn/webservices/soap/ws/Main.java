package by.training2019.autumn.webservices.soap.ws;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://localhost:4789/ws/Demo", new DemoImpl());
            System.out.println("Demo SOAP Web Service has started!");

            Endpoint.publish("http://localhost:4789/ws/Books", new BookWSImpl());
            System.out.println("Books Soap Web Service started!");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
