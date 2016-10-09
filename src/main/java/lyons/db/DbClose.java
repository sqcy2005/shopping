package lyons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by songqian on 16/9/27.
 */
public class DbClose {
  public static void addClose(PreparedStatement pstmt, Connection conn) {
    try {
      if (pstmt != null) {
        pstmt.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn) {
    try {
      if (pstmt != null) {
        pstmt.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
