package sport.test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sport.config.ConfigSport;
import sport.dao.IDaoSport;
import sport.entites.ChoixEtudiant;
import sport.metier.IMetierSport;

public class TestMetier {

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
		
	@Test(expected=Exception.class)
	public void test1() throws Exception
	{
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
		
		// doit lever une exception [pas assez de places]
		metier.setCapacites(new int[]{20,20,20,20,5});		
	}
	
	@Test(expected=Exception.class)	
	public void test1b() throws Exception{		
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
				
		// doit lever une exception [le tableau doit être de taille=5]
		metier.setCapacites(new int[]{60,30});		
	}
		
	@Test
	public void test2(){	
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
		
		// pas d'exception : il y a 90 places pour 90 étudiants 
		try{	metier.setCapacites(new int[]{10,10,25,25,20});	}
		catch(Exception ex){
			ex.printStackTrace();
			fail(ex.getMessage());
			}
	}
		
	
	@Test
	public void test3()	
	{		
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
				
		try{	
			metier.setCapacites(new int[]{40,40,40,40,40});
			metier.affecterSports();			
			// assez de place = choix1 pour tous
			for(int sport=1;sport<=5;sport++)
			{
				for(ChoixEtudiant ce:metier.getBySport(sport))
				{
					assertEquals(sport,ce.getChoix()[0]);
				}
			}			
		}
		catch(Exception ex)
		{
			fail(ex.getMessage());
		}	
	}
	
	@Test
	public void test4()	
	{		
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
		
		try{						
			// la capacite totale = 90 = nb étudiants
			metier.setCapacites(new int[]{18,18,18,18,18});			
			metier.affecterSports();	
			// vérifier qu'il y a 18 étudiants dans chaque sport
			for(int sport=1;sport<=5;sport++)
			{
				System.out.println(sport);
				assertEquals(18,metier.getBySport(sport).length);
			}			
		}
		catch(Exception ex)
		{
			fail(ex.getMessage());
		}	
	}
	
	@Test
	public void test5()	
	{		
		// récupération bean Metier
		IMetierSport metier=ctx.getBean(IMetierSport.class);
		
		try{
			// 1 seul sport possible => certains n'ont ni c1 ni c2
			metier.setCapacites(new int[]{0,0,0,0,90});			
			metier.affecterSports();
			int sum=0;
			for(ChoixEtudiant ce:metier.getBySport(5))
			{
				if(ce.getChoix()[0]!=5 && ce.getChoix()[1]!=5)
					sum=sum+1;
			}
			System.out.println(sum);
			// compter le nombre de mécontents (ni c1 ni c2)
			// afficher ce nombre sur la console et vérifier que ce nombre est >0
			
			
		}
		catch(Exception ex)
		{
			fail(ex.getMessage());
		}	
	}


}
