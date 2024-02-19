package MyUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Users {
	private int userid;
	private String username;
	private String email;
	private String Gender;

public Users(int userid,String username, String email,String Gender) {
	super();
	this.userid = userid;
	this.username = username;
	this.email =  email;
	this.Gender =  Gender;
	
}

public Users() {
	// TODO Auto-generated constructor stub
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getGender() {
	return Gender;
}

public void setGender(String gender) {
	Gender = gender;
}
	
	
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to insert data
    String sql = "INSERT INTO Users (username, email, Gender) VALUES (?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.username);
       preparedStatement.setString(2, this.email);
       preparedStatement.setString(3, this.Gender);
      /* preparedStatement.setString(4, this.BranchID);
       preparedStatement.setString(5, this.Telephone);
       preparedStatement.setString(6, this.Email);
       //preparedStatement.setString(6, this.gender);*/
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/abijuru_louange_orec";
	        String user = "222006680";
	        String password = "222006680";

	        String sql = "SELECT * FROM Users";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputuserid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to update data
    String sql = "UPDATE Users SET  username=? email=? Gender=? WHERE userid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getUsername());
          stm.setString(2, this.getEmail());
          stm.setString(3, this.getGender());
          /*stm.setString(4, this.getBranchID());
          stm.setString(5, this.getTelephone());
          stm.setString(6, this.getEmail());*/
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(4, inputuserid);
       
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputuserid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to delete data
    String sql = "DELETE FROM Users WHERE  userid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputuserid); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}
