package lyons.dao;

import lyons.entity.SalesMan;
import lyons.db.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by songqian on 16/9/28.
 */
public class SalesManDao {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public boolean addSalesMan(SalesMan salesMan) {
    boolean flag = false;
    conn = new DbConn().getconn();
    String sql = "INSERT INTO SALESMAN (SNAME ,SPASSWORD)VALUES (?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, salesMan.getsName());
      pstmt.setString(2, salesMan.getsPassWord());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return flag;
  }

  public boolean deleteSalesMan(String sName) {
    Boolean flag = false;
    conn = new DbConn().getconn();
    String sql = "DELETE FROM SALESMAN WHERE SNAME=?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, sName);
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return flag;
  }

  public boolean updateSalesMan(int key, SalesMan salesMan) {
    boolean flag = false;
    conn = new DbConn().getconn();
    switch (key) {
      case 1:
        String sql = "UPDATE SALESMAN SET SNAME=? WHERE SID=?";
        try {
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, salesMan.getsName());
          pstmt.setInt(2, salesMan.getsId());
          if (pstmt.executeUpdate() > 0) {
            flag = true;
          }
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          DbClose.addClose(pstmt, conn);
        }
        break;
      case 2:
        String sql2 = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";
        try {
          pstmt = conn.prepareStatement(sql2);
          pstmt.setString(1, salesMan.getsPassWord());
          pstmt.setInt(2, salesMan.getsId());
          if (pstmt.executeUpdate() > 0) {
            flag = true;
          }
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          DbClose.addClose(pstmt, conn);
        }
        break;
      default:
        break;
    }
    return flag;
  }

  public ArrayList<SalesMan> querySalesManPage(String sname) {
    ArrayList<SalesMan> salesMen = new ArrayList<SalesMan>();
    conn = new DbConn().getconn();
    sname = "%" + sname + "%";
    String sql = "SELECT * FROM SALESMAN WHERE SNAME LIKE ?";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, sname);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String pass = rs.getString(3);
        SalesMan salesman = new SalesMan(id, name, pass);
        salesMen.add(salesman);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return salesMen;
  }
  public ArrayList<SalesMan> displaySalesMan(){
    ArrayList<SalesMan> salesMen = new ArrayList<SalesMan>();
    conn =new DbConn().getconn();
    String sql = "SELECT * FROM SALESMAN";
    try {
      pstmt=conn.prepareStatement(sql);
      rs =pstmt.executeQuery();
      while (rs.next()){
        int id = rs.getInt(1);
        String name =rs.getString(2);
        String pass =rs.getString(3);
        SalesMan salesMan =new SalesMan(id,name,pass);
        salesMen.add(salesMan);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      DbClose.addClose(pstmt,conn);
    }
    return salesMen;
  }

}
