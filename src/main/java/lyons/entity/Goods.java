package lyons.entity;

/**
 * Created by songqian on 16/9/27.
 */
public class Goods {
  private int gid;
  private String gname;
  private double gprice;
  private int gnum;

  public Goods(String gname, double gprice, int gum) {
    this.gname = gname;
    this.gprice = gprice;
    this.gnum = gum;
  }

  public Goods(int gid, String gname) {
    this.gid = gid;
    this.gname = gname;
  }

  public Goods(int id, double gprice) {
    this.gid = id;
    this.gprice = gprice;
  }

  public Goods(int id, int gnum) {
    this.gid = id;
    this.gnum = gnum;
  }

  public Goods(int id, String gname, double gprice, int gnum) {
    this.gid = id;
    this.gname = gname;
    this.gprice = gprice;
    this.gnum = gnum;
  }


  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public double getGprice() {
    return gprice;
  }

  public void setGprice(double gprice) {
    this.gprice = gprice;
  }

  public int getGnum() {
    return gnum;
  }

  public void setGnum(int gnum) {
    this.gnum = gnum;
  }
}
