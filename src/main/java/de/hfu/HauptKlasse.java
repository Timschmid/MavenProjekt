package de.hfu;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Klasse dient dazu, um eingaben im Upercase-Format umzuwandeln
 */
public class HauptKlasse{
    public static void main( String[] args ){
		System.out.println("Geben sie einen string ein");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println("Ausgabe:" + input.toUpperCase());

    }


}
