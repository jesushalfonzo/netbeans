/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonParserClass;
 
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author jalfonzo
 */
public class parserJson {
   @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader("http://multimedia.telesurtv.net/api/programa/?ultimo=100&mostrar=nombre&mostrar=slug"));
            System.out.println("sfdgdgf");
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("nombre");
            String author = (String) jsonObject.get("slug");
            JSONArray companyList = (JSONArray) jsonObject.get("");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
       }
    } 
}
