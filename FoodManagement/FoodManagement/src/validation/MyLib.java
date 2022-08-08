/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dto.Food;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author macos
 */
public class MyLib {

    final private static Scanner sc = new Scanner(System.in);
//kiểm tra nhập một double
    public static double getDouble(String inputMsg, String errorMsg, double min, double max) {

        if (min > max) {
            double tmp = min;
            min = max;
            max = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                double n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }
//kiểm tra việc nhập choice ở menu
    public static int getChoice(String inputMsg, String errorMsg, int min, int max) {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        do {
            try {
                System.out.print(inputMsg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        } while (true);
    }
//kiểm tra việc nhập một chuỗi
    public static String getAString(String inputMsg, String errorMsg, String format) {

        while (true) {
            System.out.print(inputMsg);
            String s = sc.nextLine().trim();
            if (s.length() == 0 || s.isEmpty() || s.matches(format) == false) {
                System.out.println(errorMsg);
            } else {
                return s;
            }
        }
    }
//kiểm tra việc nhập type của thức ăn
    public static String getTypeEating(String message) {
        while (true) {
            System.out.println(message);
            String type = sc.nextLine().trim();
            if (type.length() == 0 || type.isEmpty()) {
                System.out.println("Don't accept empty or blank!");
                continue;
            }
            if (type.equalsIgnoreCase("FRESH") || type.equalsIgnoreCase("FAST")) {
                return type + " FOOD";
            } else {
                System.out.println("Wrong format! Campus format is FRESH/FAST (FOOD)");
            }
        }
    }
//kiểm tra việc nhập type của nước uống
    public static String getTypeDrinking(String message) {
        while (true) {
            System.out.println(message);
            String type = sc.nextLine().trim();
            if (type.length() == 0 || type.isEmpty()) {
                System.out.println("Don't accept empty or blank!");
                continue;
            }
            if (type.equalsIgnoreCase("GAS") || type.equalsIgnoreCase("ACOHOLIC") || type.equalsIgnoreCase("COMMON")) {
                return type + " DRINK";
            } else {
                System.out.println("Wrong format! Campus format is GAS/ACOHOLIC/COMMON (DRINK)");
            }
        }
    }
//kiểm tra place của food
    public static String getPlace(String message) {
        while (true) {
            System.out.println(message);
            String place = sc.nextLine().trim();
            if (place.length() == 0 || place.isEmpty()) {
                System.out.println("Don't accept empty or blank!");
                continue;
            }
            if (place.equalsIgnoreCase("COOLER") || place.equalsIgnoreCase("FREEZER")) {
                return place;
            } else {
                System.out.println("Wrong format! Campus format is COOLER/FREEZER");
            }
        }
    }
//kiểm tra việc nhập ngày tháng năm 
    public static String getDate(String inputMsg) {
        String regex = "^\\d{2}[ -|/]\\d{2}[ -|/]\\d{4}$";
        while (true) {
            System.out.print(inputMsg);
            String date = sc.nextLine().trim();
            if (date.matches(regex)) {
                int d = Integer.parseInt(date.substring(0, 2));
                int m = Integer.parseInt(date.substring(3, 5));
                int y = Integer.parseInt(date.substring(6));
                if (validDate(d, m, y)) {
                    return date.substring(0, 2) + "/" + date.substring(3, 5) + "/" + date.substring(6);
                } else {
                    System.out.println("Invalid date!");
                    continue;
                }
            }
            if (date.length() == 0 || date.isEmpty()) {
                System.out.println("Don't accept empty or blank!");
                continue;
            }
            System.out.println("Invalid date or Wrong format! the format is dd/mm/yyyy");
        }
    }
//kiểm tra việc nhập ngày tháng năm
    public static boolean validDate(int d, int m, int y) {
        int maxd = 31;
        if ((d < 1) || (d > 31) || (m < 1) || (m > 12)) {
            return false;
        }
        if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
            maxd = 30;
        }
        if (m == 2) {
            if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) {
                maxd = 29;
            } else {
                maxd = 28;
            }
        }
        return (d <= maxd);
    }
//để kiểm tra id trùng, nếu trùng thì return true
    public static boolean CheckIDDupplicated(ArrayList<Food> list, String id) {
        for (Food food : list) {
            if (id.equalsIgnoreCase(food.getId())) {
                return true;
            }
        }
        return false;
    }
//kiểm tra xem có muốn tiếp tục một chức năng nào đó hay ko 
    public static boolean isContinue(String inputMsg) {
        do {
            System.out.print(inputMsg);
            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Only choice Yes(Y) or No(N)");
        } while (true);
    }
//kiểm tra nhập tên file
    public static String getFileName(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            String s = sc.nextLine().trim();
            if (s.length() == 0 || s.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return s + ".dat";
            }
        }
    }
//kiểm tra nhập chuỗi không cần đinh dạng
    public static String getAString(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            String s = sc.nextLine().trim();
            if (s.length() == 0 || s.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return s;
            }
        }
    }
}
