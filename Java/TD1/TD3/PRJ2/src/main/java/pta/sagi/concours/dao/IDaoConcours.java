package pta.sagi.concours.dao;

import pta.sagi.concours.entities.Candidat;

public interface IDaoConcours {
	
	public Candidat[] getCandidats(int region);
	public Candidat[] getCandidatsIn(double sMin, double sMax); 
	public void add(Candidat A);
}
