package pta.sagi.concours.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigSpring;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;
import pta.sagi.concours.metier.IMetierConcours;

public class TestMetierConcours {

	private static AnnotationConfigApplicationContext ctx;
	
	@BeforeClass
	public static void setUp()
	{
		ctx = null;
		try
		{
			ctx = new AnnotationConfigApplicationContext(ConfigSpring.class);}
		catch(Exception ex) {fail("Problème Spring");}
	}
	
	@AfterClass
	public static void tearDown()
	{
		if(ctx != null) ctx.close();
	}
	
	
	@Test
	public void testLectureDao() {
		IDaoConcours dao;
		dao = ctx.getBean(IDaoConcours.class);
		Candidat[] candidats = dao.getCandidatsIn(75, 78);
		for(Candidat c:candidats)
		{
			System.out.println(c);
		}
	}
	
	@Test
	public void testMetier1()
	{
		IMetierConcours metier = ctx.getBean(IMetierConcours.class);
		System.out.println(metier);
	}

}
