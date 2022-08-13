package main;

import pta.sagi.sport.dao.DaoSportMySQL;
import pta.sagi.sport.entites.ChoixEtudiant;

public class Main {

	public static void main(String[] args) {

		DaoSportMySQL A= new DaoSportMySQL();
		ChoixEtudiant[] Gr = A.getAll();
		int size = A.getCount();
		for(ChoixEtudiant Az : Gr)
		{
			System.out.println(Az);
		}
	//	System.out.println(size);
		
				
	}

}
