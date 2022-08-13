package pta.sagi.concours.test;
import org.junit.Test;

import pta.sagi.concours.dao.DaoConcoursJSON;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;

import static org.junit.Assert.*;

import java.util.Arrays;

public class TestDaoConcours {
	@Test
	public void testDao1() {
		IDaoConcours dao = new DaoConcoursJSON("dataJ3.json");
		Candidat[] candidats = dao.getCandidats(2);
		System.out.println(Arrays.toString(candidats));
		if(candidats!=null)
		{
		for(Candidat c:candidats)
		{
			if(c.getRegion()!=2) fail();
		}
		}
	}
	
	@Test
	public void testDao2() {
		IDaoConcours dao = new DaoConcoursJSON("dataJ3.json");
		Candidat[] candidats = dao.getCandidatsIn(78,82);
		System.out.println(Arrays.toString(candidats));
		if(candidats!=null)
		{
		for(Candidat c:candidats)
		{
			if(c.getScore()<78) fail();
			if(c.getScore()>82) fail();
			
		}
		}
	}
	
	@Test
	public void testDao3() {
		IDaoConcours dao = new DaoConcoursJSON("dataJ3.json");
		Candidat[] candidats = dao.getCandidats(1);
		System.out.println(Arrays.toString(candidats));
		int nbRegion1=candidats.length;
		if(candidats.length>0)
		{			
			Candidat c = candidats[0];
			Candidat newC = new Candidat(c.getNom()+"_x",1452,80,1);
			dao.add(newC);
		}
		candidats = dao.getCandidats(1);
		assertEquals(nbRegion1+1,candidats.length);
		
	}	
	@Test
	public void testDao4() {
		IDaoConcours dao = new DaoConcoursJSON("dataJ3.json");
		Candidat[] candidats = dao.getCandidats(1);
		int nbRegion1=candidats.length;
		dao.delCandidat(candidats[0].getNumero());		
		candidats = dao.getCandidats(1);
		assertEquals(nbRegion1-1,candidats.length);
		
	}	
}


