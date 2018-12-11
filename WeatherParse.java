import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Compile : javac -cp .:json-simple-1.1.1.jar WeatherParse.java
// Execute : java -cp .:json-simple-1.1.1.jar WeatherParse

public class WeatherParse {

    private static String JSON_WEATHER_PATH = "weather.json";

    public static void main(String[] args) {

        FileReader jsonFile = null;
        try {
            // lecture du fichier json
            jsonFile = new FileReader(JSON_WEATHER_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        Object jsonParsed = null;
        try {
            jsonParsed = parser.parse(jsonFile);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        // récupération de la racine du document
       
        
        // on récupère l'attribut "firstname" de "student"
        
        
        // TODO parser le fichier

        // TODO récupérer la racine du document
        JSONObject root = (JSONObject) jsonParsed;
        // TODO afficher la valeur de l'attribut "name" de la racine
        String name=(String) root.get("name");
        System.out.println("City name:"+name);
        // TODO afficher les valeurs des attributs "lat" et "lon" de l'élément "coord"
        JSONObject coord = (JSONObject) root.get("coord");
        Double lon = (Double) coord.get("lon");
        Double lat = (Double) coord.get("lat");

        System.out.println("City longitude: "+lon+", City latitude: "+lat);
        // contenu dans la racine

        // TODO parcourir tous les éléments de "weather" et afficher le contenu de
        // "main"
        JSONArray weather = (JSONArray) root.get("weather");
for (int i = 0; i < weather.size(); i++) {
    JSONObject oneW= (JSONObject) weather.get(i);
    String main=(String) oneW.get("main");
    System.out.println("Weather:" + main);
}

        /*
         * Résultat attendu : City name: London City latitude: 51.51 City longitude:
         * -0.13 Weather: Drizzle Weather: Clear
         */
    }
}
