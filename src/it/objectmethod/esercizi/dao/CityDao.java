package it.objectmethod.esercizi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.esercizi.config.ConnectionFactory;
import it.objectmethod.esercizi.data.City;

public class CityDao {

	public List<City> getCities(String codiceNazione) {

		List<City> lista = new ArrayList<City>();
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			conn = ConnectionFactory.getConnection();
			String sql;
			sql = "SELECT * FROM city WHERE city.CountryCode = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, codiceNazione);
			ResultSet rs = stmt.executeQuery();

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				City citta = new City();
				citta.setCountryCode(rs.getString("CountryCode"));
				citta.setId(rs.getInt("ID"));
				citta.setName(rs.getString("Name"));
				citta.setPopulation(rs.getInt("Population"));
				lista.add(citta);

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
