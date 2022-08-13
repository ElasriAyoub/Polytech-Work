package pta.sagi.sport.dao;

import pta.sagi.sport.entites.ChoixEtudiant;

public interface IDaoSport {

	public ChoixEtudiant[] getAll();
	public ChoixEtudiant[] getByChoix(int C1);
	public int getCount();
}
