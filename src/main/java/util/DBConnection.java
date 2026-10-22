package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:XE";

    private static final String USER =
            "system";

    private static final String PASSWORD =
            "manager";

    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection = DriverManager.getConnection(
            		"jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                   "manager"
            );

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }
}