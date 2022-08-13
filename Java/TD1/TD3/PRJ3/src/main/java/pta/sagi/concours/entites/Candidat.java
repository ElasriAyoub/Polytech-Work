package pta.sagi.concours.entites;


public class Candidat 
{
	private String nom;
	private int numero;
	private double score;
	private int region;
	
	public Candidat(){}
	
	public Candidat(String nom,int numero,double score,int region){
		this.setNom(nom);
		this.setNumero(numero);
		this.setScore(score);
		this.setRegion(region);
	}
	
	public double getScore() {		return score;	}

	public void setScore(double score) {	this.score = score;	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	@Override
	public String toString()
	{
		return "nom=" + nom + ", num=" + Long.toString(numero)
			+", score=" + Double.toString(score)
			+ ", region=" + Integer.toString(region);
	}

}