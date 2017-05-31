package it.polito.tdp.rivers.model;

import java.util.*;

public class River {
	private int id;
	private String nome;
	private List<Flow> misurazioni;
	
	public River(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		misurazioni=new ArrayList<Flow>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void addMisurazione(Flow f){
		misurazioni.add(f);
	}
	public List<Flow> getMisurazioni(){
		return misurazioni;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s", nome);
	}
	
}
