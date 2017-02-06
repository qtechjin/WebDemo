package com.ustcjin.dal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by mi on 2017/2/6.
 */
public class DBUtils {

    private static Connection conn;

    static{
        try {
            FileInputStream in = new FileInputStream("/config/config.properties");
            Properties properties = new Properties();
            properties.load(in);
            in.close();

            String jdbc_driver = properties.getProperty("jdbc_driver");
            String db_url = properties.getProperty("db_url");
            String user = properties.getProperty("mysql_user");
            String password = properties.getProperty("mysql_pwd");

            //register driver
            Class.forName(jdbc_driver);
            //open connection
            conn = DriverManager.getConnection(db_url, user, password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DBUtils() throws FileNotFoundException {
    }

    public static Connection getConn(){
        return conn;
    }

    public static void closeAll(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
