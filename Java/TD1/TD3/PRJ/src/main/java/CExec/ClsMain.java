package CExec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pta.sagi.concours.entites.Candidat;

public class ClsMain {
	
	final static String url="jdbc:mysql://localhost:3306/db_concours";
	final static String user="root";
	final static String pwd="";

	public static void main(String[] args) {

		//chargement du Driver
		try{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			}
		catch(ClassNotFoundException ex)
		{
		System.out.println(ex.getMessage());
		System.exit(1); // driver non trouv�
		}
		
		Candidat A = new Candidat("EL ASRI Ayoub",12345678,91.1,1);
		// requ�te SQL
		String select = "UPDATE candidats set SCORE = ? where NUMERO = ?";
		
		
		// try-with-resources (cf M�mo p20)
		try(Connection con=DriverManager.getConnection(url,user,pwd);
		PreparedStatement ps = con.prepareStatement(select);)
		{
			ps.setDouble(1,0.5);
			ps.setInt(2,A.getNumero());
			ps.executeUpdate();
			
			//d�finit le param�tre n�1 (le seul) de la requ�te

		}
		catch(SQLException e2)
		{
			System.out.println(e2.getMessage());
		}
		
		
	}

}
