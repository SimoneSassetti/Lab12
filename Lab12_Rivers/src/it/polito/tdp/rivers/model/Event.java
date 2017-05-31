package it.polito.tdp.rivers.model;

public class Event implements Comparable<Event>{
	
	public enum Type{IN};
	
	private Flow flusso;
	private Type tipo;
	
	public Event(Flow flusso, Type tipo) {
		super();
		this.flusso = flusso;
		this.tipo = tipo;
	}
	public Flow getFlusso() {
		return flusso;
	}
	public void setFlusso(Flow flusso) {
		this.flusso = flusso;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Event e) {
		if(this.flusso.getData().isAfter(e.flusso.getData())){
			return 1;
		}else
			return -1;
	}
}
