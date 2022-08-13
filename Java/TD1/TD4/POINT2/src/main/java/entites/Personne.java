package entites;

public class Personne {

	private String nom;
	private int age;
	
	public Personne(){}
	
	public Personne(String nom,int age)
	{
		this.setNom(nom);
		this.setAge(age);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString()
	{
		return "nom=" + nom + " age=" + Integer.toString(age);
	}	
	
}
