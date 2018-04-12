/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtInput"
	private TextField txtInput; // Value injected by FXMLLoader

	@FXML // fx:id="btnCalcola"
	private Button btnCalcola; // Value injected by FXMLLoader

	@FXML // fx:id="txtResultCorretti"
	private TextArea txtResultCorretti; // Value injected by FXMLLoader

	@FXML // fx:id="txtResultErrati"
	private TextArea txtResultErrati; // Value injected by FXMLLoader

	@FXML // fx:id="btnReset"
	private Button btnReset; // Value injected by FXMLLoader

	private Model model;

	@FXML
	void doCalcolaAnagrammi(ActionEvent event) {
		txtResultCorretti.clear();
		txtResultErrati.clear();
		try {
			List<String> anagrammi = model.calcolaAnagrammi(txtInput.getText().trim());
			for (String s : anagrammi) {
				if (model.isValid(s)) {
					txtResultCorretti.appendText(s + "\n");
				} else {
					txtResultErrati.appendText(s + "\n");
				}
			}
		} catch (RuntimeException e) {
			txtResultCorretti.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		txtInput.clear();
		txtResultCorretti.clear();
		txtResultErrati.clear();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtResultCorretti != null : "fx:id=\"txtResultCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtResultErrati != null : "fx:id=\"txtResultErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}
}
