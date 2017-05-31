package it.polito.tdp.rivers.model;

import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.Type;

public class Simulator {
	
	private PriorityQueue<Event> eventi;
	
	private float qtaTotale;
	private float livello;
	
	private float fmed;
	private float fout;
	private float fin;
	
	private float Cmedio;
	private int giorniInsuff;
	private int count;
	
	public Simulator(float q, float c, float fmed) {
		qtaTotale=q;
		livello=c;
		Cmedio=c;
		giorniInsuff=0;
		count=0;
		this.fmed=fmed;
		
		eventi=new PriorityQueue<>();
	}

	public void setCoda(List<Flow> misurazioni) {
		for(Flow f: misurazioni){
			Event e=new Event(f,Type.IN);
			eventi.add(e);
		}
	}

	public void run() {
		while(!eventi.isEmpty()){
			Event e=eventi.poll();
			
			switch(e.getTipo()){
			case IN:
				this.setIn(e);
				break;
			
			default:
				System.err.println("Errore! Tipo non valido.\n");
			}
		}
		
	}

	private void setIn(Event e) {
		fin=e.getFlusso().getFlusso()*3600*24;
		double prob=Math.random();
		if(prob<0.95){
			fout=(float) (0.8*fmed);
		}else{
			fout=(float) (10*(0.8*fmed));
		}
		
		livello=livello+fin;
		count++;
		
		if(livello>=fout){
			livello=livello-fout;
		}else{
			giorniInsuff++;
			livello=0;
		}
		if(livello>qtaTotale){
			livello=qtaTotale;
		}
		Cmedio=Cmedio+livello;
		
		//IN QUESTO MODO FACCIO LA TRACIMAZIONE APPENA SFORA E NON A FINE GIORNATA
//		if(e.getFlusso().getFlusso()*3600*24+livello<=qtaTotale){
//			livello=livello+e.getFlusso().getFlusso()*3600*24;
//			count++;
//			Cmedio=Cmedio+livello;
//			double prob=Math.random();
//			if(prob<0.95){
//				fout=(float) (0.8*fmed*3600*24);
//				if(fout>livello){
//					giorniInsuff++;
//					Cmedio=Cmedio+livello;
//					livello=0;
//				}else{
//					livello=livello-fout;
//					Cmedio=Cmedio+livello;
//				}
//			}else{
//				fout=(float) (10*(0.8*fmed*3600*24));
//				if(fout>livello){
//					giorniInsuff++;
//					Cmedio=Cmedio+livello;
//					livello=0;
//				}else{
//					livello=livello-fout;
//					Cmedio=Cmedio+livello;
//				}
//			}
//		}else{
//			//tramicazione
//			livello=qtaTotale;
//		}
	}

	public String getRisultato() {
		String ris="";
		
		ris="\nIl numero di giorno in cui non si è potuta garantire l'erogazione minima sono: "+giorniInsuff;
		ris+="\nL'occupazione media del bacino è pari a: "+Cmedio/count;
		return ris;
	}	
}
