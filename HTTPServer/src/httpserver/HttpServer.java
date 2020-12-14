package httpserver;

import climatedatareader.ClimateDataReaderImpl;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class HttpServer {
    
    ClimateDataReaderImpl reader = new ClimateDataReaderImpl();

    public static void main(String[] args) {

        new HttpServer().run(Integer.parseInt(args[0]));
    }

    public void run(int port) {
        try {
            ServerSocket s = new ServerSocket(port);
            while (true) {
                new Conexion(s.accept());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class Conexion extends Thread {

        Socket soc;

        public Conexion(Socket s) {
            soc = s;
            start();
        }
        
        private String reemplazarCaracteresEspeciales(String palabra) {
            String[] caracteresMalos =  {"ü", "ñ", "á", "Á", "é", "É", "í", "Í", "ó", "Ó", "ú", "Ú"};
            String[] caracteresBuenos = {"u", "n", "a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};

            for (String letraMala : caracteresMalos) {
                if (palabra.contains(letraMala)) {
                    palabra = palabra.replace(letraMala, caracteresBuenos[Arrays.asList(caracteresMalos).indexOf(letraMala)]);
                }
            }

            return palabra;

        }


        String getLocalidades() throws Exception {
            JSONArray array;
            StringBuilder xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xml.append("<localidades>");
            if ((array = reader.readJsonClimate()) != null) {

                System.out.println( array.toJSONString() );
                for (int i = 0; i < array.size(); i++) {

                    JSONObject o = (JSONObject) array.get(i);
                    String provincia = (String) o.get("province");
                    String ciudad = (String) o.get("name");
                    JSONObject weather = (JSONObject) o.get("weather");
                    String temperatura = weather.get("temp").toString();
                    ciudad = reemplazarCaracteresEspeciales(ciudad);
                    provincia = reemplazarCaracteresEspeciales(provincia);
                    xml.append("<localidad>");
                    xml.append("<nombre>").append(ciudad).append("</nombre>");
                    xml.append("<provincia>").append(provincia).append("</provincia>");
                    xml.append("<temperatura>").append(temperatura).append("</temperatura>");
                    xml.append("</localidad>");
                }
                
            }
            
            xml.append("</localidades>");
         
            return xml.toString();

        }

        String getProvincias() throws Exception {
            JSONArray array;

            java.util.Vector<String> provincias = new java.util.Vector();

            if ((array = reader.readJsonClimate()) != null) {

                for (int i = 0; i < array.size(); i++) {

                    JSONObject o = (JSONObject) array.get(i);
                    String provincia = (String) o.get("province");
                    provincia = reemplazarCaracteresEspeciales(provincia);
                    if (!provincias.contains(provincia)) {
                        provincias.add(provincia);
                    }
                }
            }

            Collections.sort(provincias);
            StringBuilder xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xml.append("<provincias>");
            for (int i = 0; i < provincias.size(); i++) {
                xml.append("<provincia>").append(provincias.get(i)).append("</provincia>").append("\n");
            }
            xml.append("</provincias>");
            return xml.toString();
        }

        public void run() {
            String s;
            PrintWriter out;
            BufferedReader in;
            try {
                out = new PrintWriter(soc.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

                String recurso = "recurso_empty";

                while (true) {
                    if ((s = in.readLine()) != null && ! s.equals("")) {
                        if (s.startsWith("GET")) {
                            StringTokenizer st = new StringTokenizer(s);
                            st.nextToken();
                            recurso = st.nextToken().substring(1);
                        }
                    

                        String msg = "msg_empty";
                        System.out.println(recurso);

                        if (recurso.startsWith("provincias")) {
                            msg = getProvincias();
                        } else if (recurso.equals("localidades")) {
                            msg = getLocalidades();
                        } else {
                            msg = "<HTML>ERROR</HTML>";
                        }

                        out.println("HTTP/1.1 200 OK");
                        out.println("Last-Modified: " + new Date().toString());
                        out.println("Content-Type: text/xml");

                        out.println("Content-Length: " + msg.length());

                        out.println("");
                        out.println(msg);
                    }
                    sleep(1000);
                }
            } catch (Exception ex) {
                System.out.println("fin conexion");
                Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
