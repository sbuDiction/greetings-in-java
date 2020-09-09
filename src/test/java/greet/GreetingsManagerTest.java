package greet;

import net.greet.GreetingsManager;
import net.greet.tools.GreetingsMethods;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GreetingsManagerTest {

    public Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        String dbDiskURL = "jdbc:h2:file:./greetings_db_test";
        Jdbi jdbi = Jdbi.create(dbDiskURL, "sa", "");
        Handle handle = jdbi.open();
        handle.execute("create table if not exists greetings ( id integer identity, name text not null, count_time int )");
        return DriverManager.getConnection(dbDiskURL, "sa", "");
    }

    @BeforeEach
    public void cleanUpTables() {
        try {
            try (Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                statement.addBatch("delete from greetings");
                statement.executeBatch();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void greetUserTest() {
        try {
            cleanUpTables();

            GreetingsMethods greetingsMethods = new GreetingsMethods(getConnection());
            GreetingsManager manager = new GreetingsManager(greetingsMethods);

            manager.greet(new String[]{"greet", "sbu", "zulu"});

            assertEquals(manager.getGreetingsString(), "Sawubona, Sbu");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void greetMultipleUsersTest() {
        try {
            cleanUpTables();

            GreetingsMethods greetingsMethods = new GreetingsMethods(getConnection());
            GreetingsManager manager = new GreetingsManager(greetingsMethods);

            manager.greet(new String[]{"greet", "sbusiso", "SWAHILI"});
            manager.greet(new String[]{"greet", "sabelo", "RUSSIAN"});
            manager.greet(new String[]{"greet", "muzi", "CHINESE"});
            manager.greet(new String[]{"greet", "zakhele", "JAPANESE"});

            assertEquals(manager.counter(), 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void greetingsCounterTest() {
        try {
            cleanUpTables();

            GreetingsMethods greetingsMethods = new GreetingsMethods(getConnection());
            GreetingsManager manager = new GreetingsManager(greetingsMethods);

            manager.greet(new String[]{"greet", "sbu"});
            manager.greet(new String[]{"greet", "axola"});
            manager.greet(new String[]{"greet", "andile"});
            manager.greet(new String[]{"greet", "zama"});
            manager.greet(new String[]{"greet", "tholang"});
            manager.greet(new String[]{"greet", "londiwe"});
            manager.greet(new String[]{"greet", "lindani"});
            manager.greet(new String[]{"greet", "press god"});

            assertEquals(manager.counter(), 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void greetCounterUserTest() {
        try {
            cleanUpTables();
            GreetingsMethods greetingsMethods = new GreetingsMethods(getConnection());
            GreetingsManager manager = new GreetingsManager(greetingsMethods);

            manager.greet(new String[]{"greet", "sbusiso", "SWAHILI"});
            manager.greet(new String[]{"greet", "sabelo", "RUSSIAN"});
            manager.greet(new String[]{"greet", "muzi", "CHINESE"});


            assertEquals(manager.greeted("muzi"), "Muzi Was greeted 1 times.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
