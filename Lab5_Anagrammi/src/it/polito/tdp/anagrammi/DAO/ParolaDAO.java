package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {

	public boolean isValid(String parola) {

		String sql = "SELECT nome FROM parola WHERE nome=?";
		boolean trovato = false;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet res = st.executeQuery();

			if (res.next()) {
				trovato = true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return trovato;
	}

}
