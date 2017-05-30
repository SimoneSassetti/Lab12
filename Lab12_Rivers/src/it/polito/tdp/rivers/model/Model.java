package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.*;

import it.polito.tdp.rivers.dao.RiverDAO;

public class Model {
	
	private List<River> fiumi;
	private List<Flow> misurazioni;
	RiverDAO dao;
	
	public Model(){
		dao=new RiverDAO();
	}
	
	public List<River> getFiumi(){
		if(fiumi==null)
			fiumi=dao.getRivers();
		return fiumi;
	}
	
	public List<Flow> getMisurazioni(River r){
		if(misurazioni==null)
			misurazioni=dao.getMisurazioni(r);
		return misurazioni;
	}
	public void setMisurazioni() {
		misurazioni=null;
	}
	public LocalDate getPrimaMisurazione(River r){
		List<Flow> mis=this.getMisurazioni(r);
		return mis.get(0).getData();
	}
	public LocalDate getUltimaMisurazione(River r){
		List<Flow> mis=this.getMisurazioni(r);
		return mis.get(mis.size()-1).getData();
	}
	public int getNumeroMisurazioni(River r){
		List<Flow> mis=this.getMisurazioni(r);
		return mis.size();
	}
	public float getValMedioFlusso(River r){
		List<Flow> mis=this.getMisurazioni(r);
		float temp=0;
		for(Flow f: mis){
			temp=temp+f.getFlusso();
		}
		return temp/mis.size();
	}
	
	
}
