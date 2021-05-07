package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.repository.DataModelRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/datamodel")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataModelEndpoint {

    @Inject
    DataModelRepository dataModelRepository;

    @POST
    @Path("addDataModel")
    @Transactional
    public void addDataModel(DataModel dataModel){
        dataModelRepository.addDataModel(dataModel);
    }

}
