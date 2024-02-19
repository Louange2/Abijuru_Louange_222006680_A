package MyPayments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payments {
	private int paymentsid;
	private String transactionid;
	private String date;
	private String amount;
	private String method;
	
	public Payments(int paymentsid, String transactionid, String date, String amount,String method) {
		
		super();
		this.paymentsid = paymentsid;
		this.transactionid = transactionid;
		this.date = date;
		this.amount = amount;
		this. method =  method;
		
		}

	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentsid() {
		return paymentsid;
	}

	public void setPaymentsid(int paymentsid) {
		this.paymentsid = paymentsid;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	


public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to insert data
    String sql = "INSERT INTO Payments (transactionid, date, amount, method) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.transactionid);
       preparedStatement.setString(2, this.date);
       preparedStatement.setString(3, this.amount);
       preparedStatement.setString(4, this.method);
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

	        String sql = "SELECT * FROM Payments";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputpaymentsid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to update data
    String sql = "UPDATE Payments SET  paymentid=?, date=?, amount=?, method=? WHERE paymentid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getTransactionid());
          stm.setString(2, this.getDate());
          stm.setString(3, this.getAmount());
          stm.setString(4, this.getMethod());
         /* stm.setString(5, this.getTelephone());
          stm.setString(6, this.getEmail());*/
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputpaymentsid);
       
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
public void delete(int inputpaymentsid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/abijuru_louange_orec";
    String user = "222006680";
    String password = "222006680";

    // SQL query to delete data
    String sql = "DELETE FROM Payments WHERE  paymentid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputpaymentsid); // Assuming there is a column named 'id' for the WHERE clause

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
