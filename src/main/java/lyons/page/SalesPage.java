package lyons.page;

import lyons.entity.SalesMan;
import lyons.tools.ScannerChoice;
import lyons.dao.SalesManDao;

import java.util.ArrayList;

/**
 * Created by songqian on 16/9/28.
 */
public class SalesPage extends ScannerChoice {
  public static void addSalesManPage() {
    System.out.println("正在执行添加售货员操作");
    System.out.println("添加售货员-姓名");
    String sName = ScannerInfoString();
    System.out.println("添加售货员-密码");
    String sPssswd = ScannerInfoString();
    SalesMan salesMan = new SalesMan(sName, sPssswd);
    boolean flag = new SalesManDao().addSalesMan(salesMan);
    if (flag = true) {
      System.out.println("添加售货员成功");
    } else {
      System.out.println("添加售货员失败");
    }
    //
  }

  public static void deleteSalesManPage() {
    System.out.println("正在执行删除售货员操作");
    System.out.println("输入要删除的员工姓名");
    String sName = ScannerInfoString();
    //
    do {
      System.out.println("确认删除该售货员 Y/ N");
      String choice = ScannerInfoString();
      if ("y".equals(choice) || "Y".equals(choice)) {
        boolean booldelete = new SalesManDao().deleteSalesMan(sName);
        if (booldelete = true) {
          System.out.println("删除成功");
        } else {
          System.err.print("删除失败");
        }
      } else if ("n".equals(choice) || "N".equals(choice)) {
        MainPage.salesManMangement();
      }
      System.err.print("输入错误，请重新输入");
    } while (true);
  }

  public static void updateSalesManPage() {
    System.out.println("正在执行更新售货员操作");
    System.out.println("输入要更改人的姓名");
    String sName = ScannerInfoString();
    //

    //
    System.out.println("输入需要更改的内容");
    System.out.println("1 更改姓名");
    System.out.println("2 更改密码");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-2]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            MainPage.salesManMangement();
            break;
          case 1:
            System.out.println("请输入新的名字");
            String newName = ScannerInfoString();
            SalesMan salesManName = new SalesMan( ?, newName, null);
            boolean flag = new SalesManDao().updateSalesMan(1, salesManName);
            if (flag = true) {
              System.out.println("更新姓名成功");
            } else {
              System.err.println("更新失败");
            }

            break;
          case 2:
            System.out.println("输入新的密码");
            String newPass = ScannerInfoString();
            SalesMan salesManPass = new SalesMan( ?,?,?);
            boolean flag1 = new SalesManDao().updateSalesMan(2, salesManPass);
            if (flag1 = true) {
              System.out.println("更新密码成功");
            } else {
              System.err.println("更新失败");
            }
            break;
          default:
            break;
        }
      }
      System.out.println("输入错误，请重新输入");
    } while (true);
  }

  public static void querySalesManPage() {
    System.out.println("正在执行售货员查询操作");
    System.out.println("请输入要查询的姓名的关键字");
    String sName = ScannerInfoString();
    ArrayList<SalesMan> salesMen = new SalesManDao().querySalesManPage(sName);
    if (salesMen.size() <= 0) {
      System.out.println("没有要查询的人的信息");
    } else {
      System.out.println("所有售货员列表");
      System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
      for (int i = 0, length = salesMen.size(); i < length; i++) {
        SalesMan salesMan = salesMen.get(i);
        System.out.println("\t" + salesMan.getsId() + "\t\t" + salesMan.getsName() + "\t\t" + salesMan.getsPassWord());
        System.out.println();
      }
    }
  }

  public static void displaySalesManPage() {
    System.out.println("正在执行售货员信息打印程序");
    ArrayList<SalesMan> salesMen = new SalesManDao().displaySalesMan();
    if(salesMen.size()<=0){
      System.out.println("售货员列表为空");
      MainPage.salesManMangement();
    }
    else{
      System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
      for(int i=0,length=salesMen.size();i<length;i++){
        SalesMan salesMan = salesMen.get(i);
        System.out.println("\t"+salesMan.getsId()+"\t\t"+salesMan.getsName()+"\t\t"+salesMan.getsPassWord());
        System.out.println();
      }
      do{
        System.out.println("输入0返回上层菜单");
        String choice = ScannerInfoString();
        if("0".equals(choice)){
          MainPage.salesManMangement();
        }
        else {
          System.out.println("出错");
        }
      }
    }

  }

}




















