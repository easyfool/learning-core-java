package com.wangfengbabe.learning.jdbc;

import static com.wangfengbabe.learning.jdbc.Constant.MYJDBC_URL;
import static com.wangfengbabe.learning.jdbc.Constant.MYSQL_DRIVER_CLASS;
import static com.wangfengbabe.learning.jdbc.Constant.PASSWORD;
import static com.wangfengbabe.learning.jdbc.Constant.USER_NAME;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfeng on 13/08/2017.
 */
public class DbUtil {

  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName(MYSQL_DRIVER_CLASS);
      connection = DriverManager.getConnection(MYJDBC_URL, USER_NAME, PASSWORD);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static void closeConnection(Connection connection) {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void closeStatement(Statement statement) {
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void closeResultSet(ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static boolean isTableExistsAlready(Connection connection, String tableName) {
    if (tableName == null || tableName.trim().equals("")) {
      return false;
    }
    List<String> tables = new ArrayList<String>();
    try {
      DatabaseMetaData dbmd = connection.getMetaData();
      ResultSet resultset = dbmd
          .getTables(connection.getCatalog(), "root", tableName.toUpperCase(), new String[]{"TABLE"});
      while (resultset.next()) {
        tables.add(resultset.getString("TABLE_NAME"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return tables.contains(tableName);

  }

}
