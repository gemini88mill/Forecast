package io.raphaelmiller;

import java.util.Scanner;

public class Main {

    private static String[] cla;

    public static void main(String[] args) {
	// write your code here
        cla = new String[args.length];
        cla = args;

        WebsiteController wc = new WebsiteController(cla[0]);

        System.out.println("hello world");
        wc.connectUnderground();


        System.exit(1);
    }

    public String getUserInput(String input){
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        return input;
    }
}
