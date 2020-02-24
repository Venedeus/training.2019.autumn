package by.training2019.autumn.webservices.soap.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Demo {
    @WebMethod
    public String helloWorld();

    @WebMethod
    public String sayHi(String fullName);
}
