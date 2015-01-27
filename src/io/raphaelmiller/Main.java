package io.raphaelmiller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WebsiteController wc = new WebsiteController(args);

        System.out.println("hello world");



        System.exit(1);
    }

    public String getUserInput(String input){
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        return input;
    }
}
