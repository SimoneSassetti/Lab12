package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flow {
	
	private int id;
	private LocalDate data;
	private float flusso;
	private River river;
	
	public Flow(int id, LocalDate data, float flusso, River river) {
		super();
		this.id = id;
		this.data = data;
		this.flusso = flusso;
		this.river = river;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public float getFlusso() {
		return flusso;
	}
	public void setFlusso(float flusso) {
		this.flusso = flusso;
	}
	public River getRiver() {
		return river;
	}
	public void setRiver(River river) {
		this.river = river;
	}
	
	
	
}
