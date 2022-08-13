package sport.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sport.entites.ChoixEtudiant;

public class TestEntites {

	@Test
	public void test1() 
	{
						
		ChoixEtudiant ce4 = new ChoixEtudiant(1, "Martin","Jean",6,0,4);
		ChoixEtudiant ce5 = new ChoixEtudiant(2, "Martin","Jean",1,3,7);
		//Les choix et le sport sont contraints à être dans [1,5]
		assertEquals(5,ce4.getChoix()[0]);
		assertEquals(1,ce4.getChoix()[1]);		
		assertEquals(5,ce5.getSport());		
		
		
	}

}
