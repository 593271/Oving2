package no.hvl.data102.adt;

//  Representerer en node.//************************************************************
	
	public class LinearNode<T> {
		private LinearNode<T> neste;
		private T element;
		

		private int antall;

		private LinearNode<Film> start;

		/***********************************************************
		 * Oppretter en tom node
		 **********************************************************/
		public LinearNode() {
			neste = null;
			element = null;
		}

		/**********************************************************
		 * Oppretter en node med et element.
		 **********************************************************/
		public LinearNode(T elem) {
			neste = null;
			element = elem;
		}

		/**********************************************************
		 * Returnerer etterf lger.
		 **********************************************************/
		public LinearNode<T> getNeste() {
			return neste;
		}

		/**********************************************************
		 * Setter neste til node
		 **********************************************************/
		public void setNeste(LinearNode<T> node) {
			neste = node;
		}

		/**********************************************************
		 * Returnerer elementet til denne noden
		 **********************************************************/
		public T getElement() {
			return element;
		}

		/**********************************************************
		 * Setter nytt element i denne noden.
		 **********************************************************/
		public void setElement(T elem) {
			element = elem;
		}

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

		public boolean slettFilm(int filmnr) {
			if(antall == 0) {
	            return false;
	        }
	        LinearNode<Film> currentNode = start;
	        while(currentNode.getNeste()!= null) {
	            if(currentNode.getNeste().getElement().getFilmnr() == filmnr) {
	                currentNode.setNeste(currentNode.getNeste().getNeste());
	                antall--;
	                return true;

	            }
	            currentNode = currentNode.getNeste();

	        }
	        return false;
			
		}

		public void leggTilFilm(Film nyFilm) {
            if(start== null) {
                start = new LinearNode<Film>(nyFilm);
                return;

            } 

            LinearNode<Film> currentNode = start;
            while(currentNode.getNeste()!= null) {
                currentNode = currentNode.getNeste(); 
            }
            currentNode = new LinearNode<Film>(nyFilm);
            antall++;
        }

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
	}// class


