package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	// Attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	// Costruttore
	
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception{
		if(postiTotali > 0) {
			this.postiTotali = postiTotali;
		}else {
			throw new Exception("Errore: i posti totali devono essere maggiori di 0!");
		}
		
		if(data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Errore: la data non può essere precedente ad oggi!");
		}
		
		this.titolo = titolo;
		this.postiPrenotati = 0;
	}
	
	// Getters e Setters

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotale() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	// Metodi
	
	public void prenota() throws Exception{
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: la data non può essere precedente ad oggi!");
		} else if (postiPrenotati == postiTotali) {
			throw new Exception("Errore: Non ci sono più posti disponibili!");
		}
		else {
			postiPrenotati++;
		}
		
	}
	
	public void disdici() throws Exception{
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: la data non può essere precedente ad oggi!");
		} else if (postiPrenotati == 0) {
			throw new Exception("Errore: Non ci sono posti prenotati!");
		} else {
			postiPrenotati--;
		}
	}

	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(dateFormat);
		return dataFormattata + " - " + this.titolo;
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	

