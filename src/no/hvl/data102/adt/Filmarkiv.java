package no.hvl.data102.adt;

import no.hvl.data102.Sjanger;

public class Filmarkiv implements FILMarkivADT {
	// Instansvariable
	private Film[] filmTabell;
	private int antall;

	public Filmarkiv(int antall) {

		filmTabell = new Film[antall];
		antall = 0;
	}

	// Konstruktører og andre metoder
	// …fyll ut

	// 20#Walt Disney#Askepott#1950#Fantasy#Warner Bros

	@Override
	public Film[] hentFilmTabell() {
											
		return filmTabell;
	}

	private void utvidKapasitet() {// eks. utvide 10%
		Film[] hjelpetabell = new Film[(int) Math.ceil(2 * filmTabell.length)];
		for (int i = 0; i < filmTabell.length; i++) {
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;
	}

//	public void leggTilFilm(Film nyFilm) {
//
//		int filmAntall = 0;
//		for (int i = 0; i < filmTabell.length; i++) {
//
//			filmAntall = i;
//
//			if (filmTabell[i].equals(null)) {
//				filmTabell[i] = nyFilm;
//			}
//
//		}
//
//		if (filmTabell[filmAntall].equals(null)) {
//			utvidKapasitet();
//			nyFilm = filmTabell[filmAntall + 1];
//		}
//
//	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {

		if (!filmTabell[filmnr].equals(null)) {
			filmTabell[filmnr] = null;
			return true;
		}

		return false;
	}

	public Film[] soekTittel(String delstreng) {
		Film[] filmerFunnet = new Film[filmTabell.length];

		for (int i = 0; i < filmTabell.length; i++) {

			String tittelNavn = filmTabell[i].getTittel();

			if (tittelNavn.contains(delstreng)) {
				filmerFunnet[i] = filmTabell[i];
			}

		}

		return filmerFunnet;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] produsenterFunnet = new Film[filmTabell.length];

		for (int i = 0; i < filmTabell.length; i++) {

			String produsenter = filmTabell[i].getTittel();

			if (produsenter.contains(delstreng)) {
				produsenterFunnet[i] = filmTabell[i];
			}

		}

		return produsenterFunnet;
	}

	@Override
	public int antall(Sjanger sjanger) {

		int antallSjangere = 0;

		for (int i = 0; i < filmTabell.length; i++) {
			if (filmTabell[i].getSjanger().equals(sjanger)) {
				antallSjangere++;
			}

		}

		return antallSjangere;
	}

	@Override
	public int antall() {
		
		return filmTabell.length;
	}

}
