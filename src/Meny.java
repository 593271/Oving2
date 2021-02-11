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
				+ "\n3. Slett en film i arkivet");
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

			Film film = new Film(filmnr, produsent, tittel, lansering, filmselskap, Sjanger);

			System.out.println(film);

			Filmarkiv filmer = new Filmarkiv(1);
			filmer.leggTilFilm(film);

			Fil.skrivTilFil(filmer, "Filmer.txt");

		} else if (handling == 2) {

			System.out.println("Navn på Filen?");

			String arkivnavn = scan3.nextLine();

			Fil.leseFraFil(arkivnavn);

		} else if (handling == 3) {

			// laget et arkiv for at bruker skulle få lov til å teste slette funksjonen.
			Film codingMaster1 = new Film(6969, "WilliamP", "CodingMastah", 2021, "Eclipse Moviemakers",Sjanger.ACTION);
			Film Rambo13 = new Film(22, "TommyT", "Rambo13", 2012, "Cool Movies", Sjanger.ACTION);
			Film KingKong = new Film(13, "Pham", "KingKong", 2013, "PhamProductions", Sjanger.ACTION);
			Film DesertEagleMaster = new Film(666, "Huan", "DesertEagleMaster", 2002, "HuanElite", Sjanger.ACTION);

			System.out.println("1. CodingMastah");
			System.out.println("2. Rambo13");
			System.out.println("3. KingKong");
			System.out.println("4. DesertEagleMaster");

			Filmarkiv filmer = new Filmarkiv(4);
			filmer.leggTilFilm(codingMaster1);
			filmer.leggTilFilm(Rambo13);
			filmer.leggTilFilm(KingKong);
			filmer.leggTilFilm(DesertEagleMaster);

			System.out.println("Skriv inn nr på filmen du vil slette");
			int slette = scan.nextInt();

			filmer.slettFilm(slette);

			System.out.println("Film slettet, resten av filmene lagt ut på Filmer.txt");
			Fil.skrivTilFil(filmer, "Filmer.txt");

		}

		scan.close();
		scan2.close();
		scan3.close();
	}

	public static void main(String[] args) {

		Meny();

	}
}