package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantDao {

	private Connection conn;
	private PreparedStatement pr = null;

	public void addEtudiant(Etudiant et) {


		conn = ConnexionDB.getConnection();


        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionetudiants", "root", "123456");

            String query = "INSERT INTO Etudiant (nom, prenom, email) VALUES (?, ?, ?)";
            pr = conn.prepareStatement(query);
            pr.setString(1, et.getNom());
            pr.setString(2, et.getPrenom());
            pr.setString(3, et.getEmail());

            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		//System.out.println("Added "+l.toString());

	}



	public ArrayList<Etudiant> getEtudiants() {

		conn = ConnexionDB.getConnection();
		ArrayList<Etudiant> Etudiants = new ArrayList<>();

		try {
			//Class.forName("org.postgresql.Driver");
        	//conn = DriverManager.getConnection("jdbc:postgresql://remotehost.com:5432/gestionetudiants", "root", "123456");

			//Class.forName("com.mysql.cj.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionetudiants", "root", "123456");


			String query = "SELECT * FROM etudiant";

			pr =  conn.prepareStatement(query);
			//pr.setString(1, l.getNom());
			//pr.executeUpdate();

	        ResultSet rs = pr.executeQuery();

	        while (rs.next()) {
	            Etudiant et = new Etudiant();
				et.setNom(rs.getString("nom"));
				et.setPrenom(rs.getString("prenom"));
				et.setEmail(rs.getString("email"));

				Etudiants.add(et);

	            //response.getWriter().append("Nom: "+nom+", Prénom: "+prenom+", Email: "+email);
	        }

		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return Etudiants;
	}
}
