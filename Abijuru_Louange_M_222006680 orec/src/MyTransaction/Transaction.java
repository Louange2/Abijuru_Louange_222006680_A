package MyTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transaction {
	private int transactionid;
	private String userid;
	private String propertyid;
	private String date;
	private String amount;
	
	public Transaction(int transactionid, String userid,String propertyid,String date, String amount) {
		
		super();
		this.transactionid = transactionid;
		this.userid = userid;
		this.propertyid = propertyid;
		this.date = date;
		this.amount = amount;
		
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(String propertyid) {
		this.propertyid = propertyid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	


public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to insert data
    String sql = "INSERT INTO Transaction (userid, propertyid, date, amount) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.userid);
       preparedStatement.setString(2, this.propertyid);
       preparedStatement.setString(3, this.date);
       preparedStatement.setString(4, this.amount);
       /*preparedStatement.setString(5, this.Telephone);
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

	        String sql = "SELECT * FROM Transaction";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputtransactionid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to update data
    String sql = "UPDATE Transaction SET  userid=?, propertyid=? ,date=?, amount=? WHERE transactionid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getUserid());
          stm.setString(2, this.getPropertyid());
          stm.setString(3, this.getDate());
          stm.setString(4, this.getAmount());
         /* stm.setString(5, this.getTelephone());
          stm.setString(6, this.getEmail());*/
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputtransactionid);
       
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
public void delete(int inputtransactionid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to delete data
    String sql = "DELETE FROM Transaction WHERE  transactionid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputtransactionid); // Assuming there is a column named 'id' for the WHERE clause

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
