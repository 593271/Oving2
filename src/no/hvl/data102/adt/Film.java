package no.hvl.data102.adt;

import no.hvl.data102.Sjanger;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int Âr;
	private Sjanger Sjanger;
	private String filmselskap;

	
	public Film(int filmnr, String produsent, String tittel, int Âr, String filmselskap, Sjanger Sjanger) {
		super();
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.Âr = Âr;
		this.Sjanger = Sjanger;
		this.filmselskap = filmselskap;
	}
	

	public Sjanger getSjanger() {
		return Sjanger;
	}

	

	public void setSjanger(Sjanger sjanger) {
		Sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	public int get≈r() {
		return Âr;
	}

	public void set≈r(int Âr) {
		this.Âr = Âr;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}


	@Override
	public String toString() {
		return "Film [filmnr=" + filmnr + ", produsent=" + produsent + ", tittel=" + tittel + ", Âr=" + Âr
				+ ", Sjanger=" + Sjanger + ", filmselskap=" + filmselskap + "]";
	}
	
	

}
