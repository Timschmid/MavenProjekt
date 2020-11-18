package de.hfu;
import java.util.Scanner;
public class HauptKlasse{
    public static void main( String[] args ){
	System.out.println("Geben sie einen string ein");
    Scanner scan = new Scanner(System.in);
	String input = scan.nextLine();
	System.out.println("Ausgabe:" + input.toUpperCase());
	
    }
}
