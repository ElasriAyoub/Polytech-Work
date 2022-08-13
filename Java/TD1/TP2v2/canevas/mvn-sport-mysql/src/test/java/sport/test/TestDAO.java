package sport.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sport.config.ConfigSport;
import sport.dao.IDaoSport;
import sport.entites.ChoixEtudiant;

public class TestDAO {

	// contexte Spring
	private static AnnotationConfigApplicationContext ctx;
	
	
	@BeforeClass
	public static void setUp(){
		// crée le contexte Spring
		ctx=null;
		try{ ctx=new AnnotationConfigApplicationContext(ConfigSport.class);}
		catch(Exception ex){ fail("Problème Spring");}
	}
	
	@AfterClass
	public static void tearDown(){ if(ctx!=null) ctx.close(); }

		
		@Test
		public void test1() 
		{
			IDaoSport dao=ctx.getBean(IDaoSport.class);
			int count = dao.getCount();
			assertEquals(90,count);		
		}
		
		@Test
		public void test2() 
		{
			IDaoSport dao=ctx.getBean(IDaoSport.class);
			// vérifier que getAll retourne autant d'étudiants que getCount
			int count=dao.getAll().length;			
			assertEquals(dao.getCount(),count);
		}
		
		@Test
		public void test3() 
		{
			IDaoSport dao=ctx.getBean(IDaoSport.class);
			// vérifier que tous les étudiants ont choisi un sport entre 1 et 5 
			int somme=0;	
			for(int i=1;i<=5;i++){
				ChoixEtudiant[] choix=dao.getByChoix1(i);
				somme+=choix.length;			
			}
			assertEquals(dao.getCount(),somme);
		}	
		
	}



