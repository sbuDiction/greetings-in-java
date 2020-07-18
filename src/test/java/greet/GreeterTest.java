package greet;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.sql.*;

//import static org.junit.Assert.assertEquals;


public class GreeterTest {

    // set the jdbc connection string
    final String jdbcURL = "jdbc:h2:file:./target/greetings_db";

    @Test
    public void GreeterTest() throws SQLException {
        try {
            Class.forName("org.h2.Driver");

            // connect to the database
            Connection conn = DriverManager.getConnection(jdbcURL, "sa", "");

            PreparedStatement ps = conn.prepareStatement("select * from users where name = ?");
            ps.setString(1, "sbu");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.next());
            while (rs.next()) {
                System.out.println(rs.getString("NAME") + "Hello");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
