package com.benaowen.reststub.resources;

import com.benaowen.reststub.data.ApiResult;
import com.benaowen.reststub.data.Person;
import com.benaowen.reststub.persistence.PersonDB;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * Created by benowen on 29/08/2017.
 */
@Api(value="/person", description="Operations on the person object")
@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonService {
    public PersonService() {
    }

    @GET
    @Timed
    @Path("/{id}")
    public Person getPerson(@PathParam("id") int id) {
        return PersonDB.getById(id);
    }

    @DELETE
    @Timed
    @Path("/{id}")
    public Response removePerson(@PathParam("id") int id) {

        ApiResult result = new ApiResult();

        PersonDB.remove(id);

        result.setMessage("removed id "+id);
        result.setSuccess(true);

        return Response.status(Status.CREATED)
                .entity(result).build();

    }

    @GET
    @Timed
    @Path("/")
    public List<Person> getPersons() {
        return PersonDB.getAll();
    }

    @POST
    @Timed
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addPerson(Person person)
    {
        return Response.status(Status.CREATED)
                .entity(PersonDB.save(person)).build();
    }

    @PUT
    @Timed
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") final int id, Person person)
    {
        person.setId(id);
        return Response.status(Status.OK)
                .entity(PersonDB.save(person)).build();
    }
}
