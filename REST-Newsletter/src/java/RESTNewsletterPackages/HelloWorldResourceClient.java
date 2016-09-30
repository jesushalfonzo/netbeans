/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTNewsletterPackages;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
/**
 *
 * @author jalfonzo
 */
public class HelloWorldResourceClient implements HelloWorldResource {
	
	private HelloWorldResource client;
	
	public HelloWorldResourceClient() {
		// Obtener el cliente a partir de la interfaz y de donde está localizado
		client = ProxyFactory.create(HelloWorldResource.class, "http://localhost:8080/helloworld-resteasy/rest");
	}
	
	@Override
	public String getSaluda() {
		return client.getSaluda();
	}

	@Override
	public String getSaludaA(String nombre) {
		return client.getSaludaA(nombre);
	}
	
	public static void main(String[] args) {
		// Inicializacion a realizar una vez por máquina virtual
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
		
		HelloWorldResourceClient client = new HelloWorldResourceClient();
		System.out.println(client.getSaluda());
		System.out.println(client.getSaludaA("picodotdev"));
	}
}