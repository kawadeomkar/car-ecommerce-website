package com.uci.rest.db;

import java.sql.*;

/**
 * Created by tariqibrahim on 5/28/17.
 */
public class DatabaseUtils {


    public static ResultSet retrieveQueryResults(Connection connection, final String sql) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static ResultSet retrieveQueryResultsWithParam(Connection connection, final String sql, Object param) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) param);
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;


    }

    public static boolean performDBUpdate(Connection connection, String sql ) {
        PreparedStatement preparedStatement = null;
        //String... params
        try {
            System.out.println("we about to perform DBUPDATE");
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("DBUPDATE DONE"); 
            /*
            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);

            }*/

            return preparedStatement.executeUpdate() > 0 ;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
