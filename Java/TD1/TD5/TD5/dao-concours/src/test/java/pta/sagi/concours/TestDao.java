package pta.sagi.concours;

import static org.junit.Assert.*;

import org.junit.Test;

import pta.sagi.concours.dao.DaoConcoursJSON;
import pta.sagi.concours.dao.DaoConcoursMySQL;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;
import pta.sagi.concours.entites.ParserCandidat;

public class TestDao {

	private IDaoConcours dao;
	
	@Test
	public void testParserCandidat()
	{
		Candidat c = ParserCandidat.parse("[John Ford;645231;78.23;2]");
		if(c!=null) System.out.println(c);
	}
	@Test
	public void testDaoJSON()
	{
		System.out.println("Test Dao JSON");
		dao=new DaoConcoursJSON("dataJ3.json");
		Candidat[] tab=dao.getCandidats(2);
		int nbRegion2=tab.length;
		for(Candidat c:tab) System.out.println(c);
		
		tab=dao.getCandidatsIn(76,79);
		for(Candidat c:tab)	System.out.println(c);		
		
		dao.add(new Candidat(tab[tab.length-1].getNom() + "_x",tab[tab.length-1].getNumero()+1,78.2,2));
		tab=dao.getCandidats(2);
		for(Candidat c:tab) System.out.println(c);
		assertEquals(nbRegion2+1,tab.length);
	}
	
	@Test
	public void testDaoMysql()
	{
		System.out.println("Test Dao Mysql");
		dao=new DaoConcoursMySQL();
		Candidat[] tab=dao.getCandidats(2);
		int nbRegion2=tab.length;
		for(Candidat c:tab) System.out.println(c);
		
		tab=dao.getCandidatsIn(76,79);
		for(Candidat c:tab) System.out.println(c);
		
		dao.add(new Candidat(tab[tab.length-1].getNom() + "_x",tab[tab.length-1].getNumero()+1,78.2,2));
		tab=dao.getCandidats(2);
		for(Candidat c:tab) System.out.println(c);
		assertEquals(nbRegion2+1,tab.length);
	}
	

}
