package net.greet;

import java.sql.*;

public class Greet {


    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");

            Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/greetings_app_db", "sa", "");
            PreparedStatement results = conn.prepareStatement("SELECT * FROM USERS");
            ResultSet rs = results.executeQuery();
            System.out.println("loading data from query =... " + results);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
