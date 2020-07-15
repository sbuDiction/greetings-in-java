package net.greet;

import java.sql.*;

public class Greet {


    public static void main(String[] args) {
        try {
    //            final String jdbcURL = "jdbc:h2:file:./target/greetings_db";
            Class.forName("org.h2.Driver");

            // connect to the database
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://127.0.1.1:9092/~/IdeaProjects/greet-in-java/target/greetings_app_db", "sa", "");
            PreparedStatement results = conn.prepareStatement("SELECT * FROM USERS WHERE NAME = 'sbu'");
            ResultSet list = results.executeQuery();

            System.out.println(conn.getMetaData());
            System.out.println(list.getString(2));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
