package pta.sagi.sport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pta.sagi.sport.entites.ChoixEtudiant;

public class DaoSportMySQL implements IDaoSport {

	final static String url="jdbc:mysql://localhost:3306/db_sport";
	final static String user="root";
	final static String pwd="";		

	public DaoSportMySQL(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage()); 
			System.exit(1);  
		}
	}
	
	public ChoixEtudiant[] getAll() {
		String select = "SELECT * From choixsport ";
		ArrayList<ChoixEtudiant> lc = new ArrayList<ChoixEtudiant>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);)
		{
			//ps.setInt(1,region);  
			// try-with-resources
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					ChoixEtudiant c=new ChoixEtudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),0);
					lc.add(c);
				}	
				return lc.toArray(new ChoixEtudiant[0]);
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

	
	
	
	public ChoixEtudiant[] getByChoix(int C1) {

		String select = "SELECT * From choixsport where C1 = ? ";
		ArrayList<ChoixEtudiant> lc = new ArrayList<ChoixEtudiant>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setInt(1,C1);  
			// try-with-resources
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					ChoixEtudiant c=new ChoixEtudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),0);
					lc.add(c);
				}	
				return lc.toArray(new ChoixEtudiant[0]);
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

	public int getCount() {
		int size = getAll().length;
		return size;
	}

}
