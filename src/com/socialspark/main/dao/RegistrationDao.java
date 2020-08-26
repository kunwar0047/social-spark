package com.socialspark.main.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.socialspark.main.model.Registration;

public class RegistrationDao {
	public int register(Registration registration) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (fname, lname, username, password, address, contact) VALUES " +
            " ( ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
<<<<<<< HEAD
            .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "dell123");
=======
            .getConnection("jdbc:mysql://localhost:3306/SocialSpark?useSSL=false", "root", "varun");
>>>>>>> 3d21e81... second commit
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {;
            preparedStatement.setString(1, registration.getFname());
            preparedStatement.setString(2, registration.getLname());
            preparedStatement.setString(3, registration.getUsername());
            preparedStatement.setString(4, registration.getPassword());
            preparedStatement.setString(5, registration.getAddress());
            preparedStatement.setString(6, registration.getContact());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
