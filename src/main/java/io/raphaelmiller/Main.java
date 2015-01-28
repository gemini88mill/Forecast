package io.raphaelmiller;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static String[] cla;

    public static void main(String[] args) {
	// write your code here
        cla = new String[args.length];

        for (int x = 0; x < args.length; x++) {
            cla[x] = args[x];
            System.out.println(cla[x]);
        }


        WebsiteController wc = new WebsiteController(cla.clone());



        wc.HttpQueryBuilder();
        try {
            String UrlasText = wc.connectWunderground();
            System.out.println(UrlasText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wc.jParse();


        System.exit(1);
    }

    public String getUserInput(String input){
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        return input;
    }
}
