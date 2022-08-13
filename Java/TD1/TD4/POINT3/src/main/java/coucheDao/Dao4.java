package coucheDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entites.Personne;


public class Dao4 implements IDao 
{
	final static String url="jdbc:mysql://localhost:3306/db_personne";
	final static String user="root";
	final static String pwd="";		

	public Dao4(){		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage()); 
			System.exit(1); // driver non trouv� 
		}
	}
	public Personne[] getAll() {
		// TODO Auto-generated method stub
		String select = "SELECT NOM,AGE FROM personne";
		ArrayList<Personne> alp = new ArrayList<Personne>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs=ps.executeQuery();)
		{
		
			while(rs.next()){
					Personne p=new Personne(rs.getString(1),rs.getInt(2));
					alp.add(p);
				}	
				return alp.toArray(new Personne[0]);
		}
		catch(SQLException e1){
				System.out.println(e1.getMessage()); 
				return null;
		}
	}

	public void setAll(Personne[] personnes) {
		// TODO Auto-generated method stub
		String drop = "DELETE FROM personne";
		String insert = "INSERT INTO personne (id,nom,age) VALUES (?,?,?)";
		
		ArrayList<Personne> alp = new ArrayList<Personne>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd))
		{
		   con.setAutoCommit(false);	
		
			try(PreparedStatement ps = con.prepareStatement(drop);)
			{
				ps.executeUpdate();
			}
			catch(SQLException e1){
				con.rollback();
				System.out.println(e1.getMessage());
			}
		
			try(PreparedStatement ps = con.prepareStatement(insert);)
			{		
			  int id=1;
			  for(Personne p:personnes)				
			  {
				ps.setInt(1, id);
				ps.setString(2,p.getNom());
				ps.setInt(3, p.getAge());
				ps.executeUpdate();
				id++;
			  }
			}
			catch(SQLException e1){
				con.rollback();
				System.out.println(e1.getMessage());
			}	
			con.commit();
			con.setAutoCommit(true);
		}
		catch(SQLException e1)
		{
			
			System.out.println(e1.getMessage());
		}
	}
	
	@Override
	public Personne[] getByAge(int age) {
		String select = "SELECT NOM,AGE FROM personne where age=?";
		
		ArrayList<Personne> alp = new ArrayList<Personne>();
		// try-with-resources
		try(Connection con=DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setInt(1,age); //d�finit l'age
			// try-with-resources
			try(ResultSet rs=ps.executeQuery();){
				while(rs.next()){
					Personne p=new Personne(rs.getString(1),rs.getInt(2));
					alp.add(p);
				}	
				return alp.toArray(new Personne[0]);
			}
			catch(SQLException e1)
			{
			System.out.println(e1.getMessage());
			return new Personne[0];
			}			
		}
		catch(SQLException e1){
				System.out.println(e1.getMessage()); 
				return new Personne[0];
		}
	}

}
