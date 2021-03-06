package no.hvl.data102.adt;

import no.hvl.data102.Sjanger;

public class Filmarkiv2 implements FILMarkivADT {



	

	private int antall;

	private LinearNode<Film> start;

	public Filmarkiv2(int antall, LinearNode<Film> start) {
		this.antall = antall;
		this.start = start;
	}

	@Override
	public Film[] hentFilmTabell() {

		Film[] filmer = new Film[antall];
		LinearNode<Film> currentNode = start;

		while (currentNode.getNeste() != null) {
			int i = 0;
			filmer[i] = currentNode.getElement();
			currentNode = currentNode.getNeste();
			i++;
		}

		return filmer;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (start == null) {
			start = new LinearNode<Film>(nyFilm);
			return;

		}

		LinearNode<Film> currentNode = start;
		while (currentNode.getNeste() != null) {
			currentNode = currentNode.getNeste();
		}
		currentNode = new LinearNode<Film>(nyFilm);
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (antall == 0) {
			return false;
		}
		LinearNode<Film> currentNode = start;
		while (currentNode.getNeste() != null) {
			if (currentNode.getNeste().getElement().getFilmnr() == filmnr) {
				currentNode.setNeste(currentNode.getNeste().getNeste());
				antall--;
				return true;

			}
			currentNode = currentNode.getNeste();

		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		Film[] filmer = new Film[antall];
		LinearNode<Film> aktuell = start;

		for (int soek = 0; soek < antall; soek++) {
			if (aktuell.getElement().getTittel() == delstreng) {
				filmer[soek] = aktuell.getElement();
			} else {
				aktuell = aktuell.getNeste();
			}
		}

		return filmer;

	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		Film[] filmer = new Film[antall];
		LinearNode<Film> aktuell = start;

		for (int soek = 0; soek < antall; soek++) {
			if (aktuell.getElement().getProdusent() == delstreng) {
				filmer[soek] = aktuell.getElement();
			} else {
				aktuell = aktuell.getNeste();
			}
		}

		return filmer;

	}

	// Tidskompleksiteten til denne metoden er O(n)
	@Override
	public int antall(Sjanger sjanger) {

		int antallSjangere = 0;
		LinearNode<Film> aktuell = start;

		for (int soek = 0; soek < antall; soek++) {
			if (aktuell.getElement().getSjanger().equals(sjanger)) {
				antallSjangere++;
				aktuell = aktuell.getNeste();
			} else {
				aktuell = aktuell.getNeste();
			}
		}

		return antallSjangere;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
	}
	// OBS! Ingen referanse til siste, kun start
	/*
	 * Klassen skal ha de samme operasjoner som for Filmarkiv i �ving 2, men pass p�
	 * at implementeringen av alle metoder blir tilpasset den nye strukturen.
	 */

}// class
