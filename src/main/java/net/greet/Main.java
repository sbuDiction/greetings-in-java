package net.greet;

import net.greet.tools.AppStater;
import net.greet.tools.CommandProcessor;
import net.greet.tools.GreetingsMethods;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;

import static spark.Spark.port;

public class Main {
    static public int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }

    static public Connection getConnectionFromDb() throws Exception {
        String dbDiskURL = "jdbc:h2:file:./greetings_db";
        Jdbi jdbi = Jdbi.create(dbDiskURL, "sa", "");
        Handle handle = jdbi.open();
        handle.execute("create table if not exists greetings ( id integer identity, name text not null, count_time int )");
        return DriverManager.getConnection(dbDiskURL, "sa", "");
    }

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.h2.Driver");
            new AppStater(getConnectionFromDb());
            GreetingsMethods greetingsMethods = new GreetingsMethods(getConnectionFromDb());
            CommandProcessor app_processor = new CommandProcessor(greetingsMethods);
            app_processor.Processor();
            port(getHerokuAssignedPort());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
