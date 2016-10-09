package lyons.page;

import lyons.tools.ScannerChoice;

/**
 * Created by songqian on 16/9/27.
 */
public class MainPage extends ScannerChoice {

  public static void mainPage() {
    System.out.println("*************************");
    System.out.println("1,商品维护");
    System.out.println("2,前台收银");
    System.out.println("3,商品管理");
    System.out.println("**************************");
    System.out.println("请输入选项，或者按0退出");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-3]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            System.out.println("------------");
            System.out.println("您已经退出系统");
            System.exit(1);
            break;
          case 1:
            MaintenancePage();
            break;
          case 2:
            checkstandLogPage();
          case 3:
            commodityMangementPage();
            break;
          default:
            break;
        }
      }
      System.err.print("输入有错误");
      System.out.print("重新选择或者输入0退出");
    }
    while (true);
  }

  public static void MaintenancePage() {
    System.out.println("******************");
    System.out.println("1添加商品");
    System.out.println("2更改商品");
    System.out.println("3删除商品");
    System.out.println("4查询商品");
    System.out.println("5显示所有商品");
    System.out.println("*******************");
    System.out.println("请输入选项或者按0返回上级菜单");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-5]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            mainPage();
            break;
          case 1:
            GoodsPage.addGoodsPage();
            break;
          case 2:
            GoodsPage.updateGoodsPage();
            break;
          case 3:
            GoodsPage.deleteGoodsPage();
            break;
          case 4:
            GoodsPage.queryGoodsPage();
            break;
          case 5:
            GoodsPage.displayGoodsPage();
            break;
          default:
            break;
        }
      }
      System.err.println("输入有错误");
      System.out.println("请重新输入或者按0退出");
    } while (true);
  }


  public static void checkstandLogPage() {

    System.out.println("******欢迎使用员工管理系统********");
    System.out.println("1登录系统");
    System.out.println("2退出");
    System.out.println("-------------------------------");
    System.out.println("请输入选项或者按0返回上级菜单");
    do {
      int loginTimes;
      String choice = ScannerInfoString();
      String regex = "[0-2]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(regex);
        switch (info) {
          case 0:
            mainPage();
            case1:
            loginTimes = 3;
            while (loginTimes != 0) {
              loginTimes--;
              System.out.println("-----用户名-----");
              String sName = ScannerInfoString();
              System.out.println("-----密码-----");
              String sPssWord = ScannerInfoString();
            }

            //logintimes =0
            System.out.println("--------------");
            System.out.println("强制请出系统");
            System.exit(1);


            case2:
            System.out.println("-------------");
            System.out.println("您已退出系统");
            System.exit(1);
          default:
            break;
        }
      }
      System.out.println("输入有错误");
      System.out.println("请重新输入或者按0退出");
    } while (true);
  }

  public static void commodityMangementPage() {
    System.out.println("**********************");
    System.out.println("1售货员管理");
    System.out.println("2列出当日卖出列表");
    System.out.println("**********************");
    System.out.println("请输入选项，或者按0返回上层菜单");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-2]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            mainPage();
            break;
          case 1:
            salesManMangement();
            break;
          case 2:
          default:
            break;
        }
      }
      System.out.println("输入错误，重新输入或者按0返回上层菜单");
    } while (true);
  }

  public static void salesManMangement() {
    System.out.println("******************");
      System.out.println("1，添加售货员");
    System.out.println("2，更改售货员");
    System.out.println("3，删除售货员");
    System.out.println("4，查询售货员");
    System.out.println("5,显示所有售货员");
    System.out.println("*******************");
    System.out.println("请选择输入或者按0返回上级菜单");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-5]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            commodityMangementPage();
            break;
          case 1:
            SalesPage.addSalesManPage();
            break;
          case 2:
            SalesPage.updateSalesManPage();
            break;
          case 3:
            SalesPage.deleteSalesManPage();
            break;
          case 4:
            SalesPage.querySalesManPage();
            break;
          case 5:
            SalesPage.displaySalesManPage();
            break;
          default:
            break;
        }
      }
    } while (true);


  }
}
