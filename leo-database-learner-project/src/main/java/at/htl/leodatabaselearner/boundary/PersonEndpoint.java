package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.repository.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonEndpoint {

  @Inject
  PersonRepository personRepository;

  @GET
  @Path("/getAll")
  public List<Person> getAllPersons() {

    final List<Person> result = personRepository.findAll();

    return result;

  }

}
