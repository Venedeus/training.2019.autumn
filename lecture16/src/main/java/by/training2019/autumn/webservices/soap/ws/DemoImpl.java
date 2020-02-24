package by.training2019.autumn.webservices.soap.ws;

import by.training2019.autumn.webservices.soap.client.Demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "by.training2019.autumn.webservices.soap.ws.Demo")
public class DemoImpl implements Demo {
    @WebMethod
    public String helloWorld() {
        return "Hello World!";
    }

    @WebMethod
    public String sayHi(String fullName) {
        return "Hi " + fullName;
    }
}
