package it.polito.tdp.regine.model;

import java.util.List;

public class Regine {
	
	// N è il numero di righe e colonne dlela scacchiera
	//    (righe e colonna numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	//      List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena ( devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	
	
	private void cerca(List<Integer> parziale, int livello) {
		
		if (livello== N) {
			// caso terminale
		} else {
			for (int colonna = 0; colonna<N; colonna++) {
				//if se posso nella casella [livello] [colonna] è valida
				// se sì aggiung a parziale e fai ricorsione
			}
		}
	}

}
