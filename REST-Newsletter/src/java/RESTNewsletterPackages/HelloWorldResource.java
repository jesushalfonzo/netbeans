/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTNewsletterPackages;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author jalfonzo
 */
@Path("/helloworld")
public interface HelloWorldResource {

	@GET
	@Path("/saluda")
	public String getSaluda();
	
	@GET
	@Path("/saluda/{nombre}")
	public String getSaludaA(@PathParam("nombre") String nombre);
}