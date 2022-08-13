package test;
import pta.sagi.magasin.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProduitAuPoids {

	@Test
	public void test() {
		Produit prod1 = new Produit("Piles",2.2);
		assertEquals("Piles",prod1.getNom());
		assertEquals(2.2,prod1.getPrix(),0.00001);
		assertTrue(prod1 instanceof IProduit);
		
		ProduitAuPoids prod2=new ProduitAuPoids("Bananes",2,0.4);
		assertTrue(prod2 instanceof IProduit);
		assertTrue(prod2 instanceof IProduitAuPoids);
		
		assertEquals("Bananes",prod2.getNom());
		assertEquals(2,prod2.getPrixAuKilo(),0.00001);
		assertEquals(0.8,prod2.getPrix(),0.00001);
		assertEquals(0.4,prod2.getPoidsKg(),0.00001);		
	}
}
