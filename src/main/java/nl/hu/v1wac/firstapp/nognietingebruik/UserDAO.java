package nl.hu.v1wac.firstapp.nognietingebruik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nl.hu.v1wac.firstapp.persistence.BaseDAOoud;

public class UserDAO extends BaseDAOoud {
	public String findRoleForUsernameAndPassword(String username, String password) {
		String role = null;
		String query = "SELECT role FROM useraccount WHERE username = ? AND password = ?";
		
		try (Connection con = super.getConnection()) {
		
			PreparedStatement pstmt = con.prepareStatement(query);	
			pstmt.setString(1, username);		
			pstmt.setString(2, password);
		
			ResultSet rs = pstmt.executeQuery();
		
			if (rs.next())
				role = rs.getString("role");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return role;
	}

}
