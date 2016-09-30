/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ScriptJsonClima;

/**
 *
 * @author jvillegas
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static ScriptJsonClima.ProcessXML.generateXML;
import java.util.Properties;
import org.w3c.dom.Document;

public class JsonParserGeneral {
    
     public static void main() throws FileNotFoundException,
            IOException, ParseException {
        Properties props = new wtProperties().getProperties();
        String ruta = props.getProperty("rutaConfig");
        String BodyMail = "Estados Metereologicos Cargados: \n";
        
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ruta));
        SendMail sendMail = new SendMail();
        
         //System.out.println(jsonArray.toString());

        ProcessXML.Display disp = new ProcessXML.Display();
        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;

            String strUrl = (String) person.get("url");
            Document doc = generateXML("ciudad", strUrl);
            String acu = ProcessXML.Display.getConditions(doc);
            BodyMail += acu;
        }
            sendMail.SendAlertToMail(BodyMail);

    }

}

         
    
