package by.training2019.autumn.controllers;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("delete")
public class DeleteController extends AbstractController {
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBookById(@PathParam("id") int id) {
        getDao().deleteBookById(id);

        return Response.ok(new Gson().toJson(getDao().getBooks())).build();
    }
}
