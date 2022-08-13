package pta.sagi.sport.entites;

public class ChoixEtudiant {
	private int _id;
	private String _nom;
	private String _prenom;
	private int _C1;
	private int _C2;
	private int _choixsport;
	
	public ChoixEtudiant(int id, String nom, String prenom, int C1,int C2, int choixsport) 
	{
		_id= id;
		_nom= nom;
		_prenom= prenom;
		_C1=C1;
		_C2=C2;
		_choixsport= choixsport;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_prenom() {
		return _prenom;
	}

	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}

	public int get_C1() {
		return _C1;
	}

	public void set_C1(int _C1) {
		this._C1 = _C1;
	}

	public int get_C2() {
		return _C2;
	}

	public void set_C2(int _C2) {
		this._C2 = _C2;
	}

	public int get_choixsport() {
		return _choixsport;
	}

	public void set_choixsport(int _choixsport) {
		this._choixsport = _choixsport;
	}
	
	public String toString()
	{
		String ss;
		ss = get_nom() + " " +get_prenom() + " " + get_C1() + " " + get_C2(); 
		return ss;
	}

}
