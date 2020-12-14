/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climatedatareader;

import climatedatareader.ClimateDataReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
/**
 *
 * @author Anibal
 */
public class ClimateDataReaderImpl extends ClimateDataReader {

    @Override
    public JSONArray readJsonClimate() {
        JSONArray array = null;
        try {
            URL url = new URL("https://ws.smn.gob.ar/map_items/weather");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            if ((inputLine = in.readLine()) != null) {
                Object obj = JSONValue.parse(inputLine);
                array = (JSONArray) obj;
            } 
            
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(ClimateDataReaderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
}
