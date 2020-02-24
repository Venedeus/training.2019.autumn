package by.training2019.autumn.webservices.soap.client;

import by.training2019.autumn.webservices.soap.ws.Demo;

public class Client {
    public static void main(String[] args) {
        DemoImplService service = new DemoImplService();
        Demo demo = service.getDemoImplPort();
        System.out.println(service.getDemoImplPort().helloWorld());
        System.out.println(service.getDemoImplPort().sayHi("Jenia!"));
    }
}
