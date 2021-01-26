package no.hvl.data102.adt;

import java.io.BufferedReader;
import no.hvl.data102.adt.Filmarkiv;

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
		Film codingMaster4 = new Film(6971, "WilliamP", "CodingMastah", 2021, "Eclipse Moviemakers", Sjanger.ACTION);


		Filmarkiv filmer = new Filmarkiv(4);
		filmer.leggTilFilm(codingMaster1);
		filmer.leggTilFilm(codingMaster2);
		filmer.leggTilFilm(codingMaster3);
		filmer.leggTilFilm(codingMaster4);
		skrivTilFil(filmer, "Filmer.txt");

	}

	public static void skrivTilFil(Filmarkiv filmarkiv, String filnavn) {

		Film[] filmer = filmarkiv.hentFilmTabell();

		final String SKILLE = "#";
		final String filLokasjon = filnavn;
		PrintWriter utfil = null;
		FileWriter ansFil = null;

		int antall = filmer.length;

		try {
			System.out.println(antall);
			FileWriter antallF = new FileWriter(filLokasjon, true);

			PrintWriter antallP = new PrintWriter(antallF);

			antallP.println(antall);

			antallP.flush();
			antallP.close();

			for (int i = 0; i < filmer.length; i++) {

				ansFil = new FileWriter(filLokasjon, true);

				utfil = new PrintWriter(ansFil);

				utfil.print(filmer[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(filmer[i].getFilmselskap());
				utfil.print(SKILLE);
				utfil.print(filmer[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(filmer[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(filmer[i].getÅr());
				utfil.print(SKILLE);
				utfil.print(filmer[i].getSjanger().toString());
				utfil.println();
				utfil.flush();
				utfil.close();

			}
		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil : " + e);
			System.exit(3);
		}

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