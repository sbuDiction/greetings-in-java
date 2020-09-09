package net.greet.tools;

import net.greet.sql.SqlQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GreetingsMethods {
    private Connection connection;

    public GreetingsMethods(Connection connection) {
        this.connection = connection;
    }


    public void checkName(String name) {
        try {
            PreparedStatement find_user = connection.prepareStatement(String.valueOf(SqlQueries.FIND_NAME_SQL.getQuery()));
            find_user.setString(1, name);
            ResultSet resultSet = find_user.executeQuery();
            if (resultSet.next()) {
                PreparedStatement update_user_counter = connection.prepareStatement(String.valueOf(SqlQueries.UPDATE_USER_COUNTER.getQuery()));
                update_user_counter.setInt(1, resultSet.getInt("count_time") + 1);
                update_user_counter.setString(2, name);
                update_user_counter.execute();
            } else {
                PreparedStatement add_user = connection.prepareStatement(String.valueOf(SqlQueries.INSERT_NAME_SQL.getQuery()));
                add_user.setString(1, name);
                add_user.setInt(2, 1);
                add_user.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Map<String, Integer> getGreeted_names() throws SQLException {
        Map<String, Integer> greetedList = new HashMap<>();
        PreparedStatement get_all_the_content = connection.prepareStatement(SqlQueries.GET_NAMES.getQuery());
        ResultSet resultSet = get_all_the_content.executeQuery();

        while (resultSet.next()) {
            greetedList.put(resultSet.getString("name"), resultSet.getInt("count_time"));
        }
        return greetedList;
    }


    public void deletePeople() {
        try {
            PreparedStatement statement = connection.prepareStatement((SqlQueries.CLEAR.getQuery()));
            statement.execute();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void deletePerson(String name) throws SQLException {
        PreparedStatement find_user = connection.prepareStatement(String.valueOf(SqlQueries.FIND_NAME_SQL.getQuery()));
        find_user.setString(1, name);
    }

}
