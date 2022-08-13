package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import myPackage.DossierBancaire;

//The Test annotation indicates that the public void method to which it is attached can be run as a test case.
public class MyTest2 {

	@Test  
	public void test2_1() 
	{
		DossierBancaire dossier=new DossierBancaire();
		dossier.deposer(900);
		try 
		{
			dossier.retirer(200);
		}catch(Exception e) {
			System.out.println("ERREUR");
		}
		System.out.println(dossier.get_solde());
		assertEquals(700,dossier.get_solde(),0);
	}

}
