package net.greet;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
            PreparedStatement results = conn.prepareStatement("SELECT * FROM USERS");
            ResultSet rs = results.executeQuery();
            System.out.println("loading data from query =... " + results);

            while (rs.next()) {
//                options for getting the data from the db.
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
