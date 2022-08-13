package pta.sagi.concours.dao;
import pta.sagi.concours.entites.*;

public interface IDaoConcours
{
	Candidat[] getCandidats(int region);
	Candidat[] getCandidatsIn(double scoreMin,double scoreMax);
	void add(Candidat c);
}
