package com.benaowen.reststub.resources;

import com.benaowen.reststub.data.Person;
import com.benaowen.reststub.persistence.PersonDB;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by benowen on 29/08/2017.
 */
@Api(value="/person", description="Operations on the person object")
@Path("/person")
public class PersonService {
    public PersonService() {
    }

    @GET
    @Timed
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) {
        return PersonDB.getById(id);
    }

    @DELETE
    @Timed
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String removePerson(@PathParam("id") int id) {
        PersonDB.remove(id);
        return "removed id "+id;
    }

    @GET
    @Timed
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return PersonDB.getAll();
    }

    @POST
    @Timed
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(Person person) {
        return PersonDB.save(person);
    }
}
