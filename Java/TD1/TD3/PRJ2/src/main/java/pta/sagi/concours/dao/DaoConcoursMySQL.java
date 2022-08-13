package pta.sagi.concours.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pta.sagi.concours.entities.Candidat;

public class DaoConcoursMySQL implements IDaoConcours{
	
	final static String url="jdbc:mysql://localhost:3306/db_concours";
	final static String user="root";
	final static String pwd="";

	public DaoConcoursMySQL()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
			System.exit(1); // driver non trouv�
			}
	}
	
	public Candidat[] getCandidats(int region) {
		
		ArrayList<Candidat> lc = new ArrayList<Candidat>();
		
		String select = "SELECT NOM,NUMERO,SCORE,REGION FROM candidats WHERE REGION=?";
		
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setInt(1,region);
			try(ResultSet rs=ps.executeQuery();)
			{
				
				while(rs.next())
				{
					Candidat C = new Candidat(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getInt(4));
					lc.add(C);
				}
				return lc.toArray(new Candidat[0]);
			}
			catch(SQLException e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		catch(SQLException e2)
		{
			System.out.println(e2.getMessage());
		}

		return null;
	}

	public Candidat[] getCandidatsIn(double sMin, double sMax) {
		ArrayList<Candidat> lc = new ArrayList<Candidat>();
		
		String select = "SELECT NOM,NUMERO,SCORE,REGION FROM candidats WHERE SCORE>=? AND SCORE<=?";
		
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setDouble(1,sMin);
			ps.setDouble(2,sMax);
			try(ResultSet rs=ps.executeQuery();)
			{
				
				while(rs.next())
				{
					Candidat C = new Candidat(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getInt(4));
					lc.add(C);
				}
				return lc.toArray(new Candidat[0]);
			}
			catch(SQLException e1)
			{
				System.out.println(e1.getMessage());
			}
		}
		catch(SQLException e2)
		{
			System.out.println(e2.getMessage());
		}

		return null;
	}

	public void add(Candidat A) {
		// TODO Auto-generated method stub
		
	}

}
