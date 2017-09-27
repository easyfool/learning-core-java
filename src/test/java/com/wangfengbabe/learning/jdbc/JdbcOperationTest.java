package com.wangfengbabe.learning.jdbc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangfeng on 13/08/2017.
 */
public class JdbcOperationTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOperationTest.class);

  @Test
  public void testDbConnection() {
    Connection connection = DbUtil.getConnection();
    assertThat(connection, notNullValue());
    DbUtil.closeConnection(connection);
  }

  @Test
  public void testCreateTable() throws SQLException {
    final String tableName = "STUDENTS";

    Connection connection = DbUtil.getConnection();
    if (DbUtil.isTableExistsAlready(connection, tableName)) {
      LOGGER.info("table {} already exists.", tableName);
      return;
    }
    Statement st = connection.createStatement();
    final String createTableSql = "create table " + tableName + "(id varchar(32),stu_name varchar(32));";
    st.executeUpdate(createTableSql);
    DbUtil.closeStatement(st);
    DbUtil.closeConnection(connection);
  }

  @Test
  public void testDropTable() throws SQLException {
    final String tableName = "STUDENTS";
    Connection connection = DbUtil.getConnection();
    if (!DbUtil.isTableExistsAlready(connection, tableName)) {
      LOGGER.info("table {} does not exist.");
      return;
    }
    Statement statement = connection.createStatement();
    final String dropTableSql = "DROP TABLE myjdbc." + tableName.toUpperCase();
    statement.executeUpdate(dropTableSql);
    DbUtil.closeStatement(statement);
    DbUtil.closeConnection(connection);
  }

  @Test
  public void testTransaction() {
    Connection connection = DbUtil.getConnection();

    DbUtil.closeConnection(connection);
  }

}
