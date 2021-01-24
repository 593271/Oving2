package no.hvl.data102.adt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import no.hvl.data102.Sjanger;

public class Fil {

	public static void main(String[] args) {

		Film codingMaster1 = new Film(6969, "WilliamP", "CodingMastah", 2021, "Eclipse Moviemakers", Sjanger.ACTION);
		Film codingMaster2 = new Film(6970, "WilliamP", "CodingMastah", 2021, "Eclipse Moviemakers", Sjanger.ACTION);
		Film codingMaster3 = new Film(6971, "WilliamP", "CodingMastah", 2021, "Eclipse Moviemakers", Sjanger.ACTION);

//		FILMarkivADT filmer = new Filmarkiv(3);
//		filmer.leggTilFilm(codingMaster1);
//		filmer.leggTilFilm(codingMaster2);
//		filmer.leggTilFilm(codingMaster3);
		// System.out.println(filmer);

		skrivTilFil(codingMaster1, "Filmer.txt");

		leseFraFil("Filmer.txt");
		lagNyFil("test123.txt");

	}

	public static void skrivTilFil(Film filmer, String filnavn) {

		// Film[] filmer = filmarkiv.hentFilmTabell();

		final String SKILLE = "#";
		final String ANSATT_FIL = filnavn;

		// for (int i = 0; i < filmer.length; i++) {

		// Film codingMaster = new Film(6969, "WilliamP", "Coding Mastah", 2021,
		// "Eclipse Moviemakers", Sjanger.ACTION);

		int antall = 1;

		try {

			FileWriter ansFil = new FileWriter(ANSATT_FIL, false);

			PrintWriter utfil = new PrintWriter(ansFil);

			utfil.println(antall);

			utfil.print(filmer.getFilmnr());
			utfil.print(SKILLE);
			utfil.print(filmer.getFilmselskap());
			utfil.print(SKILLE);
			utfil.print(filmer.getProdusent());
			utfil.print(SKILLE);
			utfil.print(filmer.getTittel());
			utfil.print(SKILLE);
			utfil.print(filmer.getÅr());
			utfil.print(SKILLE);
			utfil.print(filmer.getSjanger().toString());
			utfil.println();

			utfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil : " + e);
			System.exit(3);
		}
		// }

	}

	public static void leseFraFil(String filnavn) {
		try {
			File myObj = new File(filnavn);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (Exception e) {
			System.out.println("Filmarkivet eksisterer ikke");
			e.printStackTrace();
		}
	}
	
	
	  public static void lagNyFil(String filnavn) {
		    try {
		      File myObj = new File(filnavn);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }

}