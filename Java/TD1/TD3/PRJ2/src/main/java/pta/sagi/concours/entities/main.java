package pta.sagi.concours.entities;

import pta.sagi.concours.dao.DaoConcoursMySQL;

public class main {

	public static void main(String[] args) {
		DaoConcoursMySQL DAO = new DaoConcoursMySQL();
		Candidat[] Ayoub = DAO.getCandidatsIn(70,80);
		
		for(Candidat p : Ayoub)
		{
			System.out.println(p.toString());
		}
	}

}
