package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.Person;
import at.htl.leodatabaselearner.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonEndpoint {

  @Inject
  PersonRepository personRepository;

  @POST
  @Path("addPerson")
  @Transactional
  public void addPerson(Person person){
    personRepository.addPerson(person);
  }

  @GET
  @Path("/getAll")
  public List<Person> getAllPersons() {
    final List<Person> result = personRepository.findAll();
    return result;
  }

  @GET
  @Path("getById/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Person getById(@PathParam("id") Long id){
    return this.personRepository.findById(id);
  }

}
