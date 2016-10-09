package lyons.tools;

import java.util.Scanner;

/**
 * Created by songqian on 16/9/27.
 */
public class ScannerChoice {
  public static String ScannerInfoString() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入");
    return scanner.next();
  }

  public static double ScannerInfo() {
    double num = 0.00;
    do {
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入数字，保留最后两位小数点");
      String info = sc.next();
      String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";
      if (info.matches(regex)) {
        num = Double.parseDouble(info);
      } else {
        System.err.println("输入错误");
        continue;
      }
      break;
    } while (true);
    return num;
  }


  public static int ScannerNum() {
    int num = 0;
    do {
      Scanner sc = new Scanner(System.in);
      System.out.println("请输入数字");
      String info = sc.next();
      String regex = "([1-9])|([1-9][0-9]+)";
      if (info.matches(regex)) {
        num = Integer.parseInt(info);
      } else {
        System.err.print("输入错误");
        continue;
      }
      break;
    } while (true);
    return num;
  }


}
