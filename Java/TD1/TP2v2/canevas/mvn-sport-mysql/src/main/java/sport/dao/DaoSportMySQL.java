package sport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sport.entites.ChoixEtudiant;

public class DaoSportMySQL implements IDaoSport 
{
	final static String url = "jdbc:mysql://localhost:3306/db_sport";
	final static String user = "root";
	final static String pwd = "";

	public DaoSportMySQL()
	{
		try{Class.forName("com.mysql.jdbc.Driver"); }
		catch(ClassNotFoundException ex){
		System.out.println(ex.getMessage());
		System.exit(1); // driver non trouvé
		}
	}
	
	
	@Override
	public int getCount() {
		String selectCount = "select count(*) from etudiants";
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(selectCount);
		ResultSet rs=ps.executeQuery();)
		{
			if(rs.next())	return rs.getInt(1);	
			else return 0;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}		
	}
	
	@Override
	public ChoixEtudiant[] getAll() {
		ArrayList<ChoixEtudiant> list = new ArrayList<ChoixEtudiant>();
		String selectAll = "select * from etudiants";
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(selectAll);
		ResultSet rs=ps.executeQuery();)
		{
			while(rs.next())
			{
				ChoixEtudiant c=new ChoixEtudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5), 0);
				list.add(c);
			}
			return list.toArray(new ChoixEtudiant[0]);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}			
	}

	@Override
	public ChoixEtudiant[] getByChoix1(int choix1) {
		ArrayList<ChoixEtudiant> list = new ArrayList<ChoixEtudiant>();
		String selectAll = "select * from etudiants";
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(selectAll);
		ResultSet rs=ps.executeQuery();)
		{
			while(rs.next())
			{
				ChoixEtudiant c=new ChoixEtudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5), 0);
				if(rs.getInt(4)==choix1)
					list.add(c);
			}
			return list.toArray(new ChoixEtudiant[0]);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}			
	}	
	

}
