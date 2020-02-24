package by.training2019.autumn.webservices.soap.ws;

import by.training2019.autumn.webservices.soap.model.BookDAO;
import by.training2019.autumn.webservices.soap.model.Book;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "by.training2019.autumn.webservices.soap.ws.BookWS")
public class BookWSImpl implements BookWS {
    private BookDAO dao = new BookDAO();

    @Override
    public List<Book> getBooks() {
        return dao.getBooks();
    }
}
