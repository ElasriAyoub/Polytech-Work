package test;
import pta.sagi.magasin.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestPanier {

	@Test
	public void test1() {
		Panier p = new Panier();
		assertEquals(0,p.getTaille());
		IProduit[] produits = p.getProduits();
		assertEquals(0,produits.length);		
	}
	
	@Test
	public void test2() {
		
		IProduit[] produits = {new Produit("Piles",4.5),new ProduitAuPoids("Oranges",3,0.8)};
		Panier p = new Panier(produits);
		assertEquals(2,p.getTaille());
		IProduit[] prods = p.getProduits();
		assertEquals(2,prods.length);		
	}
	
	@Test
	public void test3() {
		
		IProduit[] produits = {new Produit("Piles",4.5),new ProduitAuPoids("Oranges",3,0.8)};
		PanierPlus p = new PanierPlus(produits);
		assertEquals(2,p.getTaille());
		IProduit[] prods = p.getProduits();
		assertEquals(2,prods.length);
		assertEquals(6.9,p.getTotal(),0.0001);
	}
	
	@Test
	public void test4() {
		
		PanierPlus p = new PanierPlus();
		p.add(new Produit("Piles",3.2));
		p.add(new Produit("CahierA4",2.4));
		p.add(new ProduitAuPoids("Carottes",1.5,1.6));
		double total = p.getTotal();
		assertTrue(p.check(pr->pr.getPrix()>2));
		p.forEach(pr->pr.setPrix(pr.getPrix()*0.8));
		assertEquals(total*0.8,p.getTotal(),0.0001);
	}
}
