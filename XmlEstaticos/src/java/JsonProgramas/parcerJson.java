/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonProgramas;

import java.net.URL;
import java.util.Hashtable;
import jdk.nashorn.api.scripting.URLReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author jalfonzo
 */
public class parcerJson {

    private String nombrePrograma = "";
    private String slugPrograma;
    Hashtable<String, String> programas = new Hashtable<String, String>();

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getSlugPrograma() {
        return slugPrograma;
    }

    public void setSlugPrograma(String slugPrograma) {
        this.slugPrograma = slugPrograma;
    }

    public parcerJson() {
        
        System.out.println(nombrePrograma);
        try {
            JSONParser parser = new JSONParser();
            URL urljson = new URL("http://multimedia.telesurtv.net/api/programa/?ultimo=100&mostrar=nombre&mostrar=slug");
            JSONArray jsonArray = (JSONArray) parser.parse(new URLReader(urljson));
            for (Object o : jsonArray) {
                JSONObject prog = (JSONObject) o;

                String strNombrePrograma = (String) prog.get("nombre");
                String strSlug = (String) prog.get("slug");
                programas.put(strNombrePrograma, strSlug);
            }

           
            
        } catch (Exception e) {
        }
    }
    

    public void GetSlugProgram() {
        
       if (programas.containsKey(nombrePrograma)) {
                slugPrograma = programas.get(nombrePrograma);
            } else {
                slugPrograma = "null";
            
            }

    }

}
