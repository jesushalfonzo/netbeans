/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTNewsletterPackages;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
/**
 *
 * @author jalfonzo
 */
public class HelloWorldResourceImpl implements HelloWorldResource {

	@Override
	public String getSaluda() {
		return "¡Hola mundo!";
	}
	
	@Override
	public String getSaludaA(String nombre) {
		return MessageFormat.format("¡Hola {0}!", nombre);
	}
}