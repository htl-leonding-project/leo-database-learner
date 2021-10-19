package at.htl.leodatabaselearner.boundary;

import at.htl.leodatabaselearner.entity.DataModel;
import at.htl.leodatabaselearner.entity.SqlScript;
import at.htl.leodatabaselearner.repository.SqlScriptRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sqlscript")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SqlScriptEndpoint {

    @Inject
    SqlScriptRepository sqlScriptRepository;

    @POST
    @Path("add_sqlscript")
    @Transactional
    public void addSqlScript(SqlScript sqlScript) {
        sqlScriptRepository.addSqlScript(sqlScript);
    }

    @GET
    @Path("get_all")
    public List<SqlScript> getAllSqlScripts() {
        return sqlScriptRepository.findAllSqlScripts();
    }

    @GET
    @Path("getbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public SqlScript getById(@PathParam("id") Long id) {
        return this.sqlScriptRepository.findById(id);
    }
}
