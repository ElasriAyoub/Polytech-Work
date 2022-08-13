package pta.sagi.concours.metier;

import pta.sagi.concours.entites.Candidat;

public interface IMetierConcours {
	public Candidat[] getCandidats(int ... regions);
	public Candidat[] getTop(int region);
	public void add(Candidat c);
	public void setTopSize(int size);
	public int getTopSize();

}
