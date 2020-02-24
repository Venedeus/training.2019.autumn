package by.training2019.autumn.controllers;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("library")
public class LibraryController extends AbstractController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooks() {
        return Response.ok(new Gson().toJson(getDao().getBooks())).build();
    }

    @GET
    @Path("/{id}")
    public String getBookById(@PathParam("id") int id) {
        return getDao().getBookById(id);
    }
}
