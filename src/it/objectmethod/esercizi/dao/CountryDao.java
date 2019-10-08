package it.objectmethod.esercizi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.esercizi.config.ConnectionFactory;
import it.objectmethod.esercizi.data.Country;

public class CountryDao {

	public List<Country> getCountries(String nomeContinente) {

		List<Country> lista = new ArrayList<Country>();
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			conn= ConnectionFactory.getConnection(0);
			String sql;
			sql = "SELECT * FROM country WHERE country.Continent = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nomeContinente);
			ResultSet rs = stmt.executeQuery();

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				Country nazione = new Country();
				nazione.setName(rs.getString("Name"));
				nazione.setContinent(rs.getString("Continent"));
				nazione.setCode(rs.getString("Code"));
				lista.add(nazione);

			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}

		finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}

		return lista;
	}

	public List<String> getContinents() {

		List<String> lista = new ArrayList<String>();
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			conn= ConnectionFactory.getConnection(0);
			String sql;
			sql = "SELECT  distinct country.Continent FROM country";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				lista.add(rs.getString("Continent"));
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}

		finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}

		return lista;
	}

}
