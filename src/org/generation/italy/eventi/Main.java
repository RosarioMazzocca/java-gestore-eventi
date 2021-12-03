package org.generation.italy.eventi;


import java.time.LocalDate;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
	
		LocalDate dataEvento;
		Scanner scanner = new Scanner(System.in);
		boolean confermaPrenotazione = false;
		boolean confermaDisdire = false;
		String siPrenotazione = "s";
		String noPrenotazione = "n";
		
		//titolo evento
		
		System.out.println("Inserire il nome dell'evento a cui desideri partecipare: ");
		String titolo = scanner.nextLine();
		System.out.println("Evento scelto: " + titolo);
		
		// data
		
		System.out.print("Inserisci il giorno di partecipazione dell'evento: ");
        int giorno = scanner.nextInt();
        System.out.print("Inserisci il mese: ");
        int mese = scanner.nextInt();
        System.out.print("Inserisci l'anno: ");
        int anno = scanner.nextInt();
        dataEvento = LocalDate.of(anno, mese, giorno);
        System.out.println("La data scelta è: " + dataEvento);
        
        //evento
        try {
        	
        	Evento evento = new Evento(titolo, dataEvento, anno);
            System.out.println(evento);
            System.out.println("Quanti posti totali ci sono?: ");
            int postiTotaliEvento = scanner.nextInt();
            
            //prenotazioni
            
            System.out.println("Vuoi prenotare? (s/n) ");
            scanner.nextLine();
            do {
    			String siNo = scanner.nextLine();
    			if (siNo.equals(noPrenotazione)) { //if per prenotare
    				confermaPrenotazione = false;
    				System.out.println("Nessuna prenotazione effettutata");
    				break;
    			} else if (siNo.equals(siPrenotazione)) { // prenotazione confermata
    				confermaPrenotazione = true;
    				 System.out.println("Quanto posti vuoi prenotare? ");
    				 int numeriPostiPrenotati = scanner.nextInt();
    		         for (int i = 0; i < numeriPostiPrenotati; i++) {
    		            	evento.prenota();
    		            }
    		         System.out.println("Hai prenotato " + numeriPostiPrenotati + " posti - " +  "Sono rimasti: " + (postiTotaliEvento - evento.getPostiPrenotati()) + " posti disponibili");
    		       
    			} else {
    				System.out.println("Errore: valore non valido. Inserisci 's' oppure 'n' ");
    				
    			}
    		} while (confermaPrenotazione == false);
            
            System.out.println("Vuoi disdire? (s/n) ");
            scanner.nextLine();
            do {
	            String siNoDisdire = scanner.nextLine();
	         if (siNoDisdire.equals(noPrenotazione)) {       // if innestato per disdire
	        	 confermaDisdire = false;
	        	 System.out.println("Non disdire niente allora");
    				break;
	         } else if (siNoDisdire.equals(siPrenotazione)) {
	        	 confermaDisdire = true;
	        	 System.out.println("Quanto posti vuoi disdire? ");
				 int numeriPostiDisdetti = scanner.nextInt();
		         for (int i = 0; i < numeriPostiDisdetti; i++) {
		            	evento.disdici();
		            }
		         System.out.println("Hai disdetto " + numeriPostiDisdetti + " posti - " +  "Sono rimasti: " + (postiTotaliEvento - evento.getPostiPrenotati()) + " posti disponibili");
	         } else {
	        	 System.out.println("Errore: valore non valido. Inserisci 's' oppure 'n' ");
	         } // fine if per disdire
            	
            } while (confermaDisdire == false);
            
            System.out.println("fine");
            
        } catch (Exception a){
        	System.out.println(a.getMessage());
        }
        
		
		scanner.close();
	}

}
