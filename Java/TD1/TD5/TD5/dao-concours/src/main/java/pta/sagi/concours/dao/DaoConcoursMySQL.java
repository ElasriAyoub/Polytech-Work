package pta.sagi.concours.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pta.sagi.concours.entites.Candidat;

public class DaoConcoursMySQL implements IDaoConcours
{
	final static String url="jdbc:mysql://localhost:3306/db_concours";
	final static String user="root";
	final static String pwd="";		

	public DaoConcoursMySQL(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage()); 
			System.exit(1); // driver non trouv� 
		}
	}
	
	public Candidat[] getCandidats(int region) {
		
		String select = "SELECT NOM,NUMERO,SCORE FROM candidats WHERE REGION=?";
		ArrayList<Candidat> lc = new ArrayList<Candidat>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setInt(1,region);  
			// try-with-resources
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					Candidat c=new Candidat(rs.getString(1),rs.getInt(2),rs.getDouble(3),region);
					lc.add(c);
				}	
				return lc.toArray(new Candidat[0]);
			}
			catch(SQLException e1){
				System.out.println(e1.getMessage()); 
				return null;
			}
		}
		catch(SQLException e2){
			System.out.println(e2.getMessage()); 
			return null;
		}		
	}
	
	public void add(Candidat c)
	{
		String insert = "INSERT INTO candidats (NOM,NUMERO,SCORE,REGION) VALUES(?,?,?,?)";
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(insert);)
		{
			ps.setString(1,c.getNom());  
			ps.setInt(2, c.getNumero());
			ps.setDouble(3, c.getScore());
			ps.setInt(4,c.getRegion());
			// try-with-resources
			ps.executeUpdate();			
		}
		catch(SQLException e2){
			System.out.println(e2.getMessage()); 			
		}		
	}
				

	
	public Candidat[] getCandidatsIn(double scoreMin, double scoreMax) {
		String select = "SELECT NOM,NUMERO,SCORE,REGION FROM candidats WHERE SCORE>=? AND SCORE<=?";
		ArrayList<Candidat> lc = new ArrayList<Candidat>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setDouble(1,scoreMin);  
			ps.setDouble(2,scoreMax);  
			
			// try-with-resources
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					Candidat c=new Candidat(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getInt(4));
					lc.add(c);
				}	
				return lc.toArray(new Candidat[0]);
			}
			catch(SQLException e1){
				System.out.println(e1.getMessage()); 
				return null;
			}
		}
		catch(SQLException e2){
			System.out.println(e2.getMessage()); 
			return null;
		}		
	}

}
