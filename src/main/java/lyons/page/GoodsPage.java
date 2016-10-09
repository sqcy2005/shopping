package lyons.page;

import lyons.dao.GoodsDao;
import lyons.entity.Goods;
import lyons.tools.ScannerChoice;

import java.util.ArrayList;

/**
 * Created by songqian on 16/9/27.
 */
public class GoodsPage extends ScannerChoice {
  public static void addGoodsPage() {
    System.out.println("正在执行添加商品操作");
    System.out.println("请输入商品");
    String goodsName = ScannerInfoString();
    System.out.println("输入价格");
    double goodsPrice = ScannerInfo();

    System.out.println("输入商品数量");
    int goodsNumber = ScannerNum();

    Goods goods = new Goods(goodsName, goodsPrice, goodsNumber);
    boolean flag = new GoodsDao().addGoods(goods);
    if (flag) {
      System.out.println("已成功添加商品");
    } else {
      System.out.println("添加商品失败");
    }
    //
  }

  public static void updateGoodsPage() {
    System.out.println("正在执行更改商品操作");
    System.out.println("请输入想要更改的商品名字");
    int gid
    System.out.println("请选择想要更改的内容");
    System.out.println("1更改名称");
    System.out.println("2更改价格");
    System.out.println("3更改数量");
    System.out.println("请输入选项，或者按0返回上一级菜单");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-3]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            MainPage.MaintenancePage();
            break;
          case 1:
            System.out.println("请输入商品新名称");
            String gname = ScannerInfoString();
            Goods goodsName = new Goods(gid, gname);
            boolean bool = new GoodsDao().updateGoods(1, goodsName);
            if (bool = true) {
              System.out.println("更新商品名称成功");
            } else {
              System.err.print("更新商品名称失败");
            }
            //
            break;
          case 2:
            System.out.println("请输入商品的新价格");
            double gprice = ScannerInfo();
            Goods goodsPrice = new Goods(gid, gprice);
            boolean flag = new GoodsDao().updateGoods(2, goodsPrice);
            if (flag = true) {
              System.out.println("更新商品价格成功");
            } else {
              System.err.println("更新商品价格失败");
            }
            //
            break;
          case 3:
            System.out.println("请输入商品的新价格");
            int gnum = ScannerNum();
            Goods goodsNum = new Goods(gid, gnum);
            boolean flag2 = new GoodsDao().updateGoods(3, goodsNum);
            if (flag2 = true) {
              System.out.println("更新价格成功");
            } else {
              System.err.print("更新价格失败");
            }
            //
            break;
          default:
            break;
        }
      }
      System.out.println("输入错误，重新输入或者按0返回");
    } while (true);

  }

  public static void deleteGoodsPage() {
    System.out.println("正在执行删除商品的操作");
    System.out.println("请输入要删除的商品的名称");
    int gid =
    do {
      System.out.println("确定删除该商品：Y/N");
      String choice = ScannerInfoString();
      if ("y".equals(choice) || "Y".equals(choice)) {
        boolean bool = new GoodsDao().deleteGoods(gid);
        if (bool) {
          System.out.println("删除成功");
        } else {
          System.err.print("删除失败");
        }
      } else if ("n".equals(choice) || "N".equals(choice)) {
        MainPage.MaintenancePage();
      }
    } while (true);
  }

  public static void displayGoodsPage() {
    System.out.println("所有商品的列表");
    ArrayList<Goods> goodses = new GoodsDao().displayGoods();
    if (goodses.size() <= 0) {
      System.err.println("库存为空");
      MainPage.MaintenancePage();
    } else {
      System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
      for (int i = 0, length = goodses.size(); i < length; i++) {
        Goods goods = goodses.get(i);
        System.out.println("\t" + goods.getGid() + "\t\t" + goods.getGname() + "\t\t" + goods.getGprice() + "\t\t" + goods.getGnum());
        int gNum = goods.getGnum();
        if (gNum == 0) {
          System.out.println("售罄");
        } else if (gNum < 10) {
          System.out.print("数量不足");
        } else {
          System.out.println("\t\t-");
        }
      }
      System.out.println("-------------------------------");
    }
    do {
      System.out.println("输入0返回上层菜单");
      String choice = ScannerInfoString();
      if ("0".equals(choice)) {
        MainPage.MaintenancePage();
      } else {
        System.out.println("输入错误请重新输入");
      }
    } while (true);
  }

  public static void queryGoodsPage() {
    System.out.println("正在执行商品查询");
    System.out.println("1 按照商品 数量升续查询");
    System.out.println("2 按照商品 价格升续查询");
    System.out.println("3 注入商品 关键字 查询");
    System.out.println(" 输入选项，或者按0返回上级菜单");
    do {
      String choice = ScannerInfoString();
      String regex = "[0-3]";
      if (choice.matches(regex)) {
        int info = Integer.parseInt(choice);
        switch (info) {
          case 0:
            MainPage.MaintenancePage();
            break;
          case 1:
          case 2:
          case 3:
            System.out.println("请输入商品关键字");
          default:
            break;
        }
        break;
      }
      else {
        System.out.println("输入错误，或者按0返回上层菜单");
      }

    } while (true);


  }


}
