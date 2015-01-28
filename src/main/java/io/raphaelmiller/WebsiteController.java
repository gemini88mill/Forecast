package io.raphaelmiller;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class used to scrape and collect information from the website inorder to get the 5 day forcast.
 *
 * Created by raphael on 1/27/15.
 */
public class WebsiteController {

    private final String WUNDERGROUND_KEY = "3cfd31d747b993d5";
    private final String WEATHER_UNDERGROUND = "http://api.wunderground.com/api/";


    private String[] argument;
    private String[] queryArgs;
    private String apiHttp = null;

    public void HttpQueryBuilder(){
        setApiHttp(WEATHER_UNDERGROUND + WUNDERGROUND_KEY + "/conditions/q/" + queryArgs[1] + "/" + queryArgs[0] + ".json");
        System.out.println(getApiHttp());
    }

    public void connectUnderground(){


    }

    public void arguementParser(String[] argument){
        String regex = ",\\s";

        queryArgs = argument[0].split(regex);
        for (int x = 0; x < queryArgs.length; x++) {
            System.out.println(queryArgs[x]);

        }
    }

    public WebsiteController(String[] argument) {
        this.argument = argument;
        arguementParser(argument);
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
