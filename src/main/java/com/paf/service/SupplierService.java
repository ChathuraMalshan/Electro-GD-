package com.paf.service;

import java.sql.*;
import com.paf.utils.DBConnection;
import com.paf.model.*;

public class SupplierService {
	Connection con = null;

	public SupplierService() {

		con = DBConnection.connecter();
	}

	// A common method to connect to the DB

	public String insertsupplier(Supplier supplier) {
		String query = " insert into supplier(`AccNumber`,`Units`,`UnitPrice`,`StartDate`,`EndDate`)"
				+ " values (?,?, ?, ?, ?)";

		String output;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, supplier.getAccNumber());
			preparedStatement.setFloat(2, supplier.getUnits());
			preparedStatement.setFloat(3, supplier.getUnitPrice());
			preparedStatement.setString(4, supplier.getStartDate());
			preparedStatement.setString(5, supplier.getEndDate());
			preparedStatement.execute();
			con.close();
			output = "Inserted successfully";

		} catch (SQLException e) {
			output = "Error while inserting the supplier.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readsuppliers() {
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Account No</th><th>Units</th><th>Unit Price</th><th>Start Date</th><th>End Date</th></tr>";
			String query = "select * from supplier";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String AccNumber = rs.getString("AccNumber");
				String Units = rs.getString("Units");
				String UnitPrice = rs.getString("UnitPrice");
				String StartDate = rs.getString("StartDate");
				String EndDate = rs.getString("EndDate");

				// Add into the html table
				output += "<tr><td>" + AccNumber + "</td>";
				output += "<td>" + Units + "</td>";
				output += "<td>" + UnitPrice + "</td>";
				output += "<td>" + StartDate + "</td>";
				output += "<td>" + EndDate + "</td>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the suppliers.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatesupplier(Supplier supplier) {

		String query = "UPDATE supplier SET Units=?,UnitPrice=?,StartDate=?,EndDate=? WHERE AccNumber=?";
		String output = "";
		try {

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setFloat(1, supplier.getUnits());
			preparedStatement.setFloat(2, supplier.getUnitPrice());
			preparedStatement.setString(3, supplier.getStartDate());
			preparedStatement.setString(4, supplier.getEndDate());
			preparedStatement.setString(5, supplier.getAccNumber());

			if (preparedStatement.executeUpdate() == 1) {
				output = "Updated successfully";
			} else {
				output = "Error while updating the Supplier.";
			}

			con.close();

		} catch (Exception e) {
			output = "Error while updating the supplier.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletesupplier(Supplier supplier) {
		String query = "delete from supplier where AccNumber=?";
		String output;

		try {

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement

			PreparedStatement preparedStatement = con.prepareStatement(query);
			// binding values
			preparedStatement.setString(1, supplier.getAccNumber());
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully";
//	 // execute the statement
//	 if(preparedStatement.execute()) {
//		 output = "Deleted successfully";
//	 }else {
//		 output = "id not found";
//	 }
//		
//	 con.close();

		} catch (Exception e) {
			output = "Error while deleting the supplier.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
