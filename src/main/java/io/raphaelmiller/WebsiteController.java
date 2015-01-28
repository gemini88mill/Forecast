package io.raphaelmiller;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class used to scrape and collect information from the website in order to get the 5 day forcast.
 * along with any other information needed for program.
 *
 * Created by raphael on 1/27/15.
 */
public class WebsiteController {

    private final String WUNDERGROUND_KEY = "3cfd31d747b993d5";
    private final String WEATHER_UNDERGROUND = "http://api.wunderground.com/api/";


    private String[] argument;
    private String[] queryArgs;
    private String apiHttp = null;
    private File file;

    /**
     * HttpQuery Builder: Uses weather underground API to retrieve address
     * for wunderground.json data
     */
    public void HttpQueryBuilder(){
        setApiHttp(WEATHER_UNDERGROUND + WUNDERGROUND_KEY + "/conditions/q/" + queryArgs[1] + "/" + queryArgs[0] + ".json");
        System.out.println(getApiHttp());
    }

    public void jParse(String jsonString){
        String json = null;
        try {
             json = connectWunderground(getApiHttp());;
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
        System.out.println(jsonObject.get("current_observation").getAsJsonObject().get(("temp_f")));


    }

    public String connectWunderground(String wunderConn) throws IOException {
        //String wunderConn = getApiHttp();
        BufferedReader reader = null;
        try {
            URL url = new URL(wunderConn);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1){
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                reader.close();
            }
        }
        return wunderConn;
    }

    /**
     * argumentParser method: accepts command line argument String array and
     * separates by commas and white space.
     *
     * Ex: Boston, Ma:
     *
     * yields:
     *
     * String[0] = Boston
     * String[1] = MA
     * @param argument
     */
    public void argumentParser(String[] argument){
        String regex = ",\\s";

        queryArgs = argument[0].split(regex);
        for (int x = 0; x < queryArgs.length; x++) {
            System.out.println(queryArgs[x]);

        }
    }

    //-----------------Getters and Setters-----------------

    public WebsiteController(String[] argument) {
        this.argument = argument;
        argumentParser(argument);
    }

    public String[] getArgument() {
        return argument;
    }

    public void setArgument(String[] argument) {
        this.argument = argument;
    }

    public String getApiHttp() {
        return apiHttp;
    }

    public void setApiHttp(String apiHttp) {
        this.apiHttp = apiHttp;
    }
}
