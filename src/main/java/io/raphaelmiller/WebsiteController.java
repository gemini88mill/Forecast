package io.raphaelmiller;

import java.io.IOException;
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
    private final String WEATHER_UNDERGROUND = "http://www.wunderground.com/";

    private String argument = null;

    public void connectUnderground(){
        try {
            URL url = new URL(WEATHER_UNDERGROUND);
            URLConnection conn = url.openConnection();
            conn.connect();
            System.out.println(url.getContent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    public WebsiteController(String argument){
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
