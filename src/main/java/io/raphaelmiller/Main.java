package io.raphaelmiller;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main Class (CLI Interface Controller)
 *
 * this class is used to order the program along with calling all other classes and methods
 * in the program.
 *
 * @author Raphael Miller
 * @version (alpha)
 * @since 01.28.2014
 */
public class Main {


    private static String[] cla;
    private static String UrlasText;

    /**
     * start of program. accepts String arguments and sends them to String[] cla
     * shorthand for Command Line Arguments
     * @param args
     */
    public static void main(String[] args) {
	    //new String array for sending command line args to other classes
        cla = new String[args.length];

        for (int x = 0; x < args.length; x++) {
            cla[x] = args[x];
            System.out.println(cla[x]);
        }
        // -------------------------------------------------------------

        //calls WebsiteControllerClass
        WebsiteController wc = new WebsiteController(cla.clone());

        wc.HttpQueryBuilder();
        /*try {
            //UrlasText = wc.connectWunderground();
            //System.out.println(UrlasText);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        wc.jParse(UrlasText);


        System.exit(1);
    }

    /**
     * Scanner method used to collect keyboard i/o inside the program
     * scans entire line of text and puts data into string
     * @param input
     * @return String
     */
    public String getUserInput(String input){
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        return input;
    }
}
