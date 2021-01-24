package no.hvl.data102.adt;

import no.hvl.data102.Sjanger;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		Film film = new Film(0, null, null, 0, null, null);

		return film;

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {

		System.out.println(film.toString());

	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng) {

		System.out.println(filma.soekTittel(delstreng));

	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		System.out.println(filma.soekProdusent(delstreng));
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FILMarkivADT filma) {

		System.out.println("Det finnes totalt " + filma.antall() + " filmer");
		System.out.println("Det finnes " + filma.antall(Sjanger.ACTION) + " filmer i action sjangeren");
		System.out.println("Det finnes " + filma.antall(Sjanger.DRAMA) + " filmer i action sjangeren");
		System.out.println("Det finnes " + filma.antall(Sjanger.HISTORY) + " filmer i action sjangeren");
		System.out.println("Det finnes " + filma.antall(Sjanger.SCIFI) + " filmer i action sjangeren");
		
	}
	
}
