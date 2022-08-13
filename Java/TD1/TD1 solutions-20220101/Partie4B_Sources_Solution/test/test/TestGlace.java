package test;
import pta.sagi.glacier.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGlace {

	@Test
	public void test1() {
		
		Glace g1=new Glace2P(new Boule("Citron",2.2),new Boule("Chocolat",1.5));
		assertEquals(3.7,g1.getPrix(),0.0001);		
	}
	
	@Test(expected=Exception.class)
	public void test2() throws Exception
	{
		Glace g1=new Glace2P(new Boule("Citron",2.2),new Boule("Chocolat",1.5));
		g1.add(new Boule("Noisettes",2.8));
	}

	
	@Test
	public void test3() throws Exception
	{
		Glace g1=new Glace(4);
		assertEquals(0,g1.getTaille());
		assertEquals(0,g1.getPrix(),0.00001);
		assertEquals(4,g1.getCapacite());				
		g1.add(new Boule("Noisettes",2.8));
		assertEquals(1,g1.getTaille());
		assertEquals(2.8,g1.getPrix(),0.00001);
		g1.add(new Boule("Chocolat",1.5));
		assertEquals(2,g1.getTaille());
		assertEquals(4.3,g1.getPrix(),0.00001);		
	}
	
}
