package lyons.dao;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by songqian on 16/9/27.
 */
public class GoodsDao {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  public boolean addGoods(Goods goods) {
    boolean bool = false;
    conn = new DbConn().getconn();
    String sql = "INSERT INTO GOODS (GNAME ,GPRICE,GNUM) VALUES (?,?,?)";
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, goods.getGname());
      pstmt.setDouble(2, goods.getGprice());
      pstmt.setInt(3, goods.getGnum());
      if (pstmt.executeUpdate() > 0) {
        bool = true;
      }

    } catch (SQLException e) {

    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return bool;
  }

  public boolean updateGoods(int key, Goods goods) {
    boolean bool = false;
    conn = new DbConn().getconn();
    switch (key) {
      case 1:
        String sql = "UPDATE GOODS SET GNAME=? WHERE GID=?";
        try {
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, goods.getGname());
          pstmt.setInt(2, goods.getGid());
          if (pstmt.executeUpdate() > 0) {
            bool = true;
          }
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          DbClose.addClose(pstmt, conn);
        }
        break;
      case 2:
        String sql1 = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
        try {
          pstmt = conn.prepareStatement(sql1);
          pstmt.setDouble(1, goods.getGprice());
          pstmt.setInt(2, goods.getGid());
          if (pstmt.executeUpdate() > 0) {
            bool = true;
          }
        } catch (SQLException e) {
          e.printStackTrace();
        } finally {
          DbClose.addClose(pstmt, conn);
        }
        break;
      case 3:
        String sql2 = "UPDATE GOODS SET GNUM=? WHERE GID=?";
        try {
          pstmt = conn.prepareStatement(sql2);
          pstmt.setInt(1, goods.getGnum());
          pstmt.setInt(2, goods.getGid());
          if (pstmt.executeUpdate() > 0) {
            bool = true;
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
    return bool;

  }

  public boolean deleteGoods(int gid) {
    String sql = "DELETE FROM GOODS WHERE GID=?";
    boolean bool = false;
    conn = new DbConn().getconn();
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, gid);
      if (pstmt.executeUpdate() > 0) {
        bool = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return bool;
  }

  public ArrayList<Goods> displayGoods() {
    ArrayList<Goods> goodsList = new ArrayList<Goods>();
    String sql = "SELECT * FROM GOODS";
    conn = new DbConn().getconn();
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        double price = rs.getDouble(3);
        int num = rs.getInt(4);
        Goods goods = new Goods(id, name, price, num);
        goodsList.add(goods);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DbClose.addClose(pstmt, conn);
    }
    return goodsList;
  }

}
