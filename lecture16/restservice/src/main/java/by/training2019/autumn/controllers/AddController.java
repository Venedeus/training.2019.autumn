package by.training2019.autumn.controllers;

import by.training2019.autumn.model.Book;
import com.google.gson.Gson;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("add")
public class AddController extends AbstractController {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook() {
        getDao().addBook(new Book(getDao().getNextId(), "Tom Sawyer", 50));

        return Response.ok(new Gson().toJson(getDao().getBooks())).build();
    }
}
