/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ScriptJsonClima;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author jvillegas
 */
public class wtProperties {
    
     public Properties getProperties() {
        try {        
            Properties propiedades = new Properties();
            propiedades.load(getClass().getResourceAsStream("properties.properties"));
            
            if (!propiedades.isEmpty()) {
                return propiedades;
            } else {
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
    }
    
    
    
}
