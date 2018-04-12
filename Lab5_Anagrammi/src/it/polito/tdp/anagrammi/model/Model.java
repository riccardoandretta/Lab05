package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	ParolaDAO parolaDAO;

	private List<String> anagrammi;

	public Model() {
		parolaDAO = new ParolaDAO();
	}

	public boolean isValid(String parola) {
		return parolaDAO.isValid(parola);
	}

	public List<String> calcolaAnagrammi(String parola) {

		anagrammi = new ArrayList<>();

		cercaAnagrammi("", parola);
		// System.out.println(anagrammi);
		return anagrammi;
	}

	private void cercaAnagrammi(String primaLettera, String parolaParziale) {
		// terminazione
		if (parolaParziale.length() <= 1) {
			anagrammi.add(primaLettera + parolaParziale);

		} else {
			for (int i = 0, l = parolaParziale.length(); i < l; i++) {
				String middle = parolaParziale.substring(i, i + 1);
				String before = parolaParziale.substring(0, i);
				String after = parolaParziale.substring(i + 1);
				cercaAnagrammi(primaLettera + middle, before + after);
			}
		}

	} 
}
