/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.jf16;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author curso1
 */
public class QR_Map {

    private Map<String, String> mCapitales = new TreeMap<>();

    public void QR_Map() {
        /*
         * Map sustituye el Valor si encuentra el Key.
         */
        mCapitales.put("Francia", "Paris");
        mCapitales.put("Venezuela", "Caracas");
        mCapitales.put("Colombia", "Bogota");
        mCapitales.put("Peru", "Lima");
        mCapitales.put("España", "Madrid");
        mCapitales.put("Brasil", "Brasilia");
        mCapitales.put("Francia", "Brasilia");

        for (Map.Entry<String, String> entry : mCapitales.entrySet()) {
            String string = entry.getKey();
            String string1 = entry.getValue();
            System.out.println(string + ":" + string1);
        }

    }

    public void QR_Map01() {
        /*
         * Map sustituye los valores si encuentra un key añadido.
         */
        mCapitales.put("Francia", "Paris");
        mCapitales.put("Venezuela", "Caracas");
        mCapitales.put("Colombia", "Bogota");
        mCapitales.put("Peru", "Lima");
        mCapitales.put("España", "Madrid");
        mCapitales.put("Brasil", "Brasilia");

        /*
         * Preguntar si tiene un key "Brasil"
         */
        if (mCapitales.containsKey("Brasil")) {
            System.out.println("Contiene un key Francia");
            System.out.println("Y  su capital es : " + mCapitales.get("Brasil"));
        } else {
            mCapitales.put("Francia", "Brasilia");
        }

        /*
         * Recorrer el Map
         */
        for (Map.Entry<String, String> entry : mCapitales.entrySet()) {
            String string = entry.getKey();
            String string1 = entry.getValue();
            System.out.println(string + ":" + string1);
        }

    }

    public static void main(String[] p) {
        QR_Map objMap = new QR_Map();
        objMap.QR_Map01();
    }
}
