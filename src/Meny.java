import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JFrame;

import no.hvl.data102.Sjanger;
import no.hvl.data102.adt.FILMarkivADT;
import no.hvl.data102.adt.Fil;
import no.hvl.data102.adt.Film;
import no.hvl.data102.adt.Filmarkiv;

public class Meny {

	public static void Meny() {

		System.out.println("Hei velkommen til FilmArkivet" + "\nHva har du lyst til å gjøre?" + "\n");
		System.out.println("1. Legg til film i eksisterende filmarkiv" + "\n2. Ta en titt på et eksisterende?"
				+ "\n3. Søk film ut i fra sjanger");
		System.out.println("Tast inn nummeret til handling du har lyst til å gjøre");

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		
		int handling = scan.nextInt();

		if (handling == 1) {

			
			System.out.println("Skriv inn et filmnr");
			int filmnr = scan.nextInt();
			
			System.out.println("Skriv inn et produsent");

			String produsent = scan2.nextLine();
			
			System.out.println("Skriv inn et tittel");

			String tittel = scan2.nextLine();
			
			System.out.println("Skriv inn et lanserings år");

			int lansering = scan.nextInt();
			
			System.out.println("Skriv inn et filmselskap");

			String filmselskap = scan2.nextLine();
			
			System.out.println("Skriv inn et sjanger");

			String Sjanger1 = scan.next();
			
			Sjanger Sjanger = no.hvl.data102.Sjanger.valueOf(Sjanger1);
			
			

			
			Film film = new Film(filmnr, produsent,tittel, lansering,  filmselskap, Sjanger);
			
			
			
			System.out.println(film);
			
			Filmarkiv filmer = new Filmarkiv(1);
			filmer.leggTilFilm(film);
			
			Fil.skrivTilFil(filmer, "Filmer.txt");

		} else if (handling == 2) {

			System.out.println("Navn på Filen?");
			
			String arkivnavn = scan3.nextLine();

			
				
										Fil.leseFraFil(arkivnavn);

			

		} else if (handling == 3) {
			
			
			
			
			
			
			
		}

		scan.close();
		scan2.close();
		scan3.close();
	}

	public static void main(String[] args) {

		Meny();
		
	}
}