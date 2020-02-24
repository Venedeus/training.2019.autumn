package by.training2019.autumn.webservices.soap.ws;

import by.training2019.autumn.webservices.soap.model.Book;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface BookWS {
    @WebMethod
    List<Book> getBooks();
}
