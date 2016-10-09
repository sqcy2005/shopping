package lyons.entity;

/**
 * Created by songqian on 16/9/27.
 */
public class SalesMan {
  private int sId;
  private String sName;
  private String sPassWord;
  public SalesMan(String sName, String sPssswd){
    this.sName=sName;
    this.sPassWord=sPssswd;
  }
  public SalesMan(int sId,String sName,String sPassWord){
    this.sId=sId;
    this.sName=sName;
    this.sPassWord=sPassWord;
  }


  public int getsId() {
    return sId;
  }

  public void setsId(int sId) {
    this.sId = sId;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public String getsPassWord() {
    return sPassWord;
  }

  public void setsPassWord(String sPassWord) {
    this.sPassWord = sPassWord;
  }
}
