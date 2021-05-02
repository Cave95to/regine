package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	// N è il numero di righe e colonne della scacchiera
	//    (righe e colonna numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	//      List<Integer>
	// livello = quante righe sono già piene QUINDI MI DICE QUANTE REGINE CI SONO GIA' MA ANCHE QUALE RIGA DEVO CONSIDERARE
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	
	private int N;
	
	//salviamo TUTTE le soluzioni
	//private List<Integer> soluzione = null;
	
	private List<List<Integer>> soluzioni = null;
	
	//public List<Integer> risolvi(int N) {
	
	public List<List<Integer>> risolvi(int N) {
		
		this.N = N;
		
		List<Integer> parziale = new ArrayList<>();
		
		//questo si aggiunge per salvare TUTTE le soluzioni
		
		this.soluzioni = new ArrayList<>();
		
		//caso inizale con lista vuota e livello 0  
		cerca(parziale, 0);
		
		// restituisce SOLO ULTIMO VETTORE DI NUMERI trovato ---> è inutile fare ancora ricorsione
		// ----> trasformiamo la funzione ricorsiva in booleana
		//return this.soluzione;
		
		return this.soluzioni;
	}
	
	//private void cerca(List<Integer> parziale, int livello) {        1a versione
	
	// per stoppare ricorsione dopo aver trovato una soluzione ammissibile inseriamo boolean
	// cerca == true : trovato, cerca == false : continua a cercare
	//private boolean cerca(List<Integer> parziale, int livello) {
	
	// private boolean cerca(List<Integer> parziale, int livello) {         2a versione
	
	// dovendo salvare tutte le soluzioni non ci servono più i flag        
	private void cerca(List<Integer> parziale, int livello) {        //3a versione
		
		if (livello== N) {
			
			// caso terminale
			
		//	System.out.println(parziale);
			
			// NON VA BENEEEE !!! in questo modo stiamo solo mettendo dentro soluzione il RIFERIMENTO a parziale!!! non stiamo
			//incollando il risultato in modo indelebile!!!
			// PARZIALE ALLA FINE DELLA RICORSIONE SARA' VUOTOOOOO e quindi anche la nostra soluzione
			// this.soluzione = parziale;
			
			// MODO CORRETT0!!!!!!!!! faccio VERA  COPIA
			//this.soluzione = new ArrayList<>(parziale);
			//return true;
			
			// se voglio averle tutte devo sempre AGGIUNGERE UNA COPIA E NON PARZIALE DIRETTAMENTE
			this.soluzioni.add(new ArrayList<>(parziale));
			
		} else {
			
			for (int colonna = 0; colonna<N; colonna++) {    // [0, 6, 4, 7]
				
				//if per vedere se regina nella casella [livello] [colonna] è valida
					// se sì aggiung a parziale e fai ricorsione
				
				if (posValida(parziale, colonna)) {
					
					parziale.add(colonna);        // [0, 6, 4, 7, *] STO MODIFICANDO PARZIALE DENTRO CICLO PER FARE TENTATIVI
					
					//cerca(parziale, livello+1);    la modifichiamo per stoppare ricorsione
					
					// boolean trovato = cerca(parziale, livello+1);
					// flag così da bloccare ricorsione, perche appena troviamo una soluzione a cascata ritorniamo vero
					// e blocca tutti quelli che sarebbero dovuti essere dopo
					//if (trovato)
					//	return true;
					
					
					cerca(parziale, livello+1);
					
					
					// NECESSARIO BACKTRACKING !!!
					
					parziale.remove(parziale.size()-1);
					
				}
			}
			
			// ancora non abbiamo trovato neanche una soluzione
			// return false;
		}
	}

	// CONTROLLIAMO SE REGINA è OK
	private boolean posValida(List<Integer> parziale, int colonna) {
		
		// vediamo se la colonna è libera
		if (parziale.contains(colonna))
			return false;
		
		// vediamo se diagonali sono libere, la somma e la differenza tra righe colonne è costante di 2 elementi sulla
		// stessa diagonale
		// confrontiamo posizione (livello, colonna) con (r, c) delle regien esistenti
		
		int livello = parziale.size();
		
		for (int r = 0; r<livello; r++) {
			
			int c = parziale.get(r);
			
			if (r+c == livello+colonna || r-c == livello-colonna)
				return false;
		}
		
		return true;
	}

}
