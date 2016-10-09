package lyons.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by songqian on 16/9/27.
 */
public class DbConn {
  private static final String DBDRIVER = "com.mysql.jdbc.Driver";
  private static final String DBURL = "jdbc:mysql://localhost:3306/mydata";
  private static final String DBUSER = "root";
  private static final String DBPASS = "root";
  private Connection conn = null;

  public Connection getconn() {
    try {
      Class.forName(DBDRIVER);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
}