/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ScriptJsonClima;

/**
 *
 * @author Jvillegas
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.DOMException;
import java.util.logging.Logger;


public class ProcessXML {

    private static Logger log = Logger.getLogger(ProcessXML.class.getName());

    public ProcessXML() {
        this(log);
    }

    public ProcessXML(Logger log) {
        this.log = log;
    }

    public static void main(String[] args) throws IOException {

        Display disp = new Display();

    }

    public static Document generateXML(String urlYahoo, String url) throws IOException {

        //String url = null;
        String XmlData = null;
        // cargando url

        URL xmlUrl = new URL(url);
        InputStream in = xmlUrl.openStream();

        // parsing the XmlUrl
        Document doc = parse(in);

        return doc;

    }

    public static Document parse(InputStream is) {
        Document doc = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            doc = builder.parse(is);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "No se pudo leer el XML: " + ex);

        }
        return doc;
    }

    public static class Display {

        private static String country;
        private static String temperatura;
        private static String texto;
        private static String humedad;
        private static String visibilidad;
        private static String presion;
        private static String amanecer;
        private static String atardecer;
        private static String viento;
        private static String velocidad;
        private static String pubdate;
        private static String prevision;
        private static String city;
        private static String unit;
        private static String ruta;
        public static String Acumulador = "";

        static String getConditions(Document doc) {
            
            try {

                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("rss");
                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        NodeList nl = eElement
                                .getElementsByTagName("yweather:location");

                        for (int tempr = 0; tempr < nl.getLength(); tempr++) {

                            Node n = nl.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e = (Element) n;
                                city = e.getAttribute("city");
                                //   log.log (Level.SEVERE, "Ciudad: " + city);

                            }
                        }

                        NodeList nl2 = eElement
                                .getElementsByTagName("yweather:location");

                        for (int tempr = 0; tempr < nl2.getLength(); tempr++) {

                            Node n2 = nl2.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e2 = (Element) n2;
                                country = e2.getAttribute("country");
                                //  log.log (Level.SEVERE,"Pais: " + country);
                            }
                        }

                        NodeList nl3 = eElement
                                .getElementsByTagName("yweather:units");

                        for (int tempr = 0; tempr < nl3.getLength(); tempr++) {

                            Node n3 = nl3.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e3 = (Element) n3;
                                unit = e3.getAttribute("temperature");

                            }
                        }

                        NodeList nl4 = eElement
                                .getElementsByTagName("yweather:condition");

                        for (int tempr = 0; tempr < nl4.getLength(); tempr++) {

                            Node n4 = nl4.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e4 = (Element) n4;
                                temperatura = e4.getAttribute("temp");
                                // log.log (Level.SEVERE, "Temperatura: " + temperatura + " "
                                // + unit);
                            }
                        }

                        NodeList nl5 = eElement
                                .getElementsByTagName("yweather:condition");

                        for (int tempr = 0; tempr < nl5.getLength(); tempr++) {

                            Node n5 = nl5.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e5 = (Element) n5;
                                texto = e5.getAttribute("text");
                                //   log.log (Level.SEVERE,"Condicion Actual: " + texto);
                            }
                        }

                        NodeList nl6 = eElement
                                .getElementsByTagName("yweather:atmosphere");

                        for (int tempr = 0; tempr < nl6.getLength(); tempr++) {

                            Node n6 = nl6.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e6 = (Element) n6;
                                humedad = e6.getAttribute("humidity");
                                //  log.log (Level.SEVERE,"Humedad: " + humedad + "%");
                            }
                        }

                        NodeList nl7 = eElement
                                .getElementsByTagName("yweather:atmosphere");

                        for (int tempr = 0; tempr < nl7.getLength(); tempr++) {

                            Node n7 = nl7.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e7 = (Element) n7;
                                visibilidad = e7.getAttribute("visibility");
                                //   log.log (Level.SEVERE,"Visibilidad: " + visibilidad + " km");
                            }
                        }

                        NodeList nl8 = eElement
                                .getElementsByTagName("yweather:atmosphere");

                        for (int tempr = 0; tempr < nl8.getLength(); tempr++) {

                            Node n8 = nl8.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e8 = (Element) n8;
                                presion = e8.getAttribute("pressure");
                                //   log.log (Level.SEVERE,"Presion: " + presion + " hPa");
                            }
                        }

                        NodeList nl9 = eElement
                                .getElementsByTagName("yweather:astronomy");

                        for (int tempr = 0; tempr < nl9.getLength(); tempr++) {

                            Node n9 = nl9.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e9 = (Element) n9;
                                amanecer = e9.getAttribute("sunrise");
                                //   log.log (Level.SEVERE, "Amanercer: " + amanecer);
                            }
                        }

                        NodeList nl10 = eElement
                                .getElementsByTagName("yweather:astronomy");

                        for (int tempr = 0; tempr < nl10.getLength(); tempr++) {

                            Node n10 = nl10.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e10 = (Element) n10;
                                atardecer = e10.getAttribute("sunset");
                                //   log.log (Level.SEVERE,"Atardecer: " + atardecer);
                            }
                        }

                        NodeList nl11 = eElement
                                .getElementsByTagName("yweather:wind");

                        for (int tempr = 0; tempr < nl11.getLength(); tempr++) {

                            Node n11 = nl11.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e11 = (Element) n11;
                                viento = e11.getAttribute("direction");
                                //   log.log (Level.SEVERE,"Direccion Vientos: " + viento);
                            }
                        }

                        NodeList nl12 = eElement
                                .getElementsByTagName("yweather:wind");

                        for (int tempr = 0; tempr < nl12.getLength(); tempr++) {

                            Node n12 = nl12.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e12 = (Element) n12;
                                velocidad = e12.getAttribute("speed");
                                //  log.log (Level.SEVERE,"velocidad: " + velocidad + "km/h");
                            }
                        }

                        NodeList nl13 = eElement
                                .getElementsByTagName("yweather:condition");

                        for (int tempr = 0; tempr < nl13.getLength(); tempr++) {

                            Node n13 = nl13.item(tempr);

                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element e13 = (Element) n13;
                                pubdate = e13.getAttribute("date");
                                //  log.log (Level.SEVERE, "Ultima Actualizacion: " + pubdate);
                            }
                        }

                        NodeList nl14 = doc.getElementsByTagName("item");
                        for (int i = 0; i < nl14.getLength(); i++) {
                            Node n14 = nl14.item(i);
                            if (n14.getNodeType() != Node.ELEMENT_NODE) {
                                continue;
                            }
                            Element e14 = (Element) n14;

                            NodeList titleList = e14.getElementsByTagName("description");
                            Element titleElem = (Element) titleList.item(0);

                            Node titleNode = titleElem.getChildNodes().item(0);
                            prevision = titleNode.getNodeValue();
                            //  log.log (Level.SEVERE,"Previciones:" + prevision);

                        }
                    }

                }

                Properties props = new wtProperties().getProperties();

                String ruta = props.getProperty("JsonCity");

                //   System.out.println("SALIDA DEL ACUMULADOR"+ Acumulador);
                JSONObject obj = new JSONObject();
                obj.put("Ciudad", city);
                obj.put("Pais", country);
                obj.put("Temperatura", temperatura + " " + unit);
                obj.put("Humedad", humedad + "%");
                obj.put("Visibilidad", visibilidad + " km");
                obj.put("Presion", presion + " hPa");
                obj.put("Amanecer", amanecer);
                obj.put("Atardecer", atardecer);
                obj.put("Direccion Vientos", viento);
                obj.put("Velocidad", velocidad + "km/h");
                obj.put("Ultima Actualizacion", pubdate);
                obj.put("Previsiones", prevision);

                FileWriter file = new FileWriter(ruta + city + ".json");
                
                
                 Acumulador = "\n Ciudad: " + city+ " " + " País: " + country+ "  " + "Temperatura: "+temperatura+unit+ "  "+"Humedad: " + humedad +"%"+ " "+ "Visibilidad: "+visibilidad+ " "+"km"+"  "
                 +"Presion: "+ presion + " hPa"+ "  "+"Amanecer: "+ amanecer+"  " +"Atardecer: "+ atardecer+"  "+"Direccion Vientos: "+ viento+"  "+"Velocidad: "+ velocidad + "km/h"+"  "+ "Ultima Actualizacion: "+ pubdate +" "+ "Previsiones:"+ prevision;
                System.out.println(Acumulador);
                 
                 
                try {
                    file.write(obj.toJSONString());
                    //String body = "Archivo JSON se ha escrito correctamente..." + obj;
                    //System.out.println("\nResultado del Parseo: " + obj);

                   
                    //String salida = ("SALIDA DEL ACUMULADOR" + Acumulador);
                    

                } catch (IOException e) {

                } finally {
                    file.flush();
                    file.close();
                    
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            return Acumulador;

        }

    }
}

        
   
         
        
    

