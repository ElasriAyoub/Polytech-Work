package tests;

import static org.junit.Assert.*;
import myPackage.DossierBancaire;

import org.junit.Test;

//The Test annotation indicates that the public void method to which it is attached can be run as a test case.
public class MyTest1 {

	@Test  
	public void test1_1() 
	{
		DossierBancaire dossier=new DossierBancaire();
		dossier.deposer(100);
		assertEquals(100,dossier.get_solde(),0); //voir documentation en ligne sur assertions Junit 
	}

	@Test
	public void test1_2() 
	{
		//fail("Test1_2 Not yet implemented");
	}

}
