/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import validation.MyLib;
import java.util.ArrayList;
import java.util.Collections;
import validation.file.TextFactoryFile;

/**
 *
 * @author macos
 */
public class FoodList {

    ArrayList<Food> list;
    TextFactoryFile tf=new TextFactoryFile();

    public FoodList() throws Exception {
        list = new ArrayList<>();
//        list.add(new Food("F001", "CHOCOPICE", 0.7, "FAST FOOD", "COOLER", "10/10/2022"));
//        list.add(new Food("F009", "MEAT", 1.2, "FRESH FOOD", "FREEZER", "01/10/2021"));
//        list.add(new Food("F003", "PEPSI", 0.5, "GAS DRINK", "COOLER", "01/10/2022"));
//        list.add(new Food("F006", "WINE", 1.3, "ACOHOLIC DRINK", "COOLER", "11/12/2030"));
//        list.add(new Food("F010", "ICE", 1, "COMMON DRINK", "FREEZER", "24/06/2030"));
        tf.readInjectionFromBinaryFile(list);
    }

//trả về số lượng food trong list food
    public int getSize() {
        return list.size();
    }

//nhập một thức ăn mới
    public void addEating() {
        String id;
        while (true) {
            while (true) {
                id = MyLib.getAString("Input id(Fxxx): ", "The ID following Fxxx format, x is the digits!", "^[f,F]{1}[0-9]{3}$").toUpperCase().trim();
                if (MyLib.CheckIDDupplicated(list, id)) {
                    System.out.println("Error! Id is duplicated! Try again!");
                } else {
                    break;
                }
            }
            String name = MyLib.getAString("Input name: ", "The NAME is only characters!").toUpperCase().trim();
            double weight = MyLib.getDouble("Input weight(kg): ", "The WEIGHT is following [0-100]kilogam!", 0, 100);
            String type = MyLib.getTypeEating("Input type (FRESH/FAST (FOOD)): ").toUpperCase().trim();
            String place = MyLib.getPlace("Input place (COOLER/FREEZER): ").toUpperCase().trim();
            String expiredDate = MyLib.getDate("Input expired date(dd/mm/yyyy): ").toUpperCase().trim();
            list.add(new Food(id, name, weight, type, place, expiredDate));
            System.out.println("The food has been added!");
            if (!MyLib.isContinue("Do you want to add eating continue(yes/no): ")) {
                break;
            }
        }
    }

//nhập một nước uống mới
    public void addDrinking() {
        String id;
        while (true) {
            while (true) {
                id = MyLib.getAString("Input id(Fxxx): ", "The ID following Fxxx format, x is the digits!", "^[f,F]{1}[0-9]{3}$").toUpperCase().trim();
                if (MyLib.CheckIDDupplicated(list, id)) {
                    System.out.println("Error! Id is duplicated! Try again!");
                } else {
                    break;
                }
            }
            String name = MyLib.getAString("Input name: ", "The NAME is only characters!").toUpperCase().trim();

            double weight = MyLib.getDouble("Input weight(l): ", "The WEIGHT is following [0-100]litre!", 0, 100);

            String type = MyLib.getTypeDrinking("Input type (GAS/ACOHOLIC/COMMON (DRINK)): ").toUpperCase().trim();
            String place = MyLib.getPlace("Input place (COOLER/FREEZER): ").toUpperCase().trim();
            String expiredDate = MyLib.getDate("Input expired date(dd/mm/yyyy): ").toUpperCase().trim();
            list.add(new Food(id, name, weight, type, place, expiredDate));
            System.out.println("The food has been added!");
            if (!MyLib.isContinue("Do you want to add drinking continue(yes/no): ")) {
                break;
            }
        }
    }

//tìm vị trí của food bằng tên food
    private Food findFoodByName(String newname) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(newname)) {
                return list.get(i);
            }
        }
        return null;
    }

//nhập tên food rồi sử dụng findFoodByName() để tìm vị trí của food=> in ra food tìm thấy
    public void searchFoodByName() {
        while (true) {
            String newname = MyLib.getAString("Input name to search: ", "The NAME is only characters!").toUpperCase().trim();
            Food food = findFoodByName(newname);
            if (food == null) {
                System.out.println("The food is not existed!");
                break;
            }
            System.out.println("\n==>The information of " + newname);
            Collections.sort(list);
            System.out.println("|   ID   |           NAME           |   WEIGHT    |      TYPE      |    PLACE   |     EXPIRED DATE     |");
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equalsIgnoreCase(newname)) {
                    list.get(i).outputFood();
                }
            }
            if (!MyLib.isContinue("Do you want to search food continue(yes/no): ")) {
                break;
            }
        }
    }

//tìm vị trí của food bằng id food
    private Food findFoodbyId(String newId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(newId)) {
                return list.get(i);
            }
        }
        return null;
    }

//nhập id  food rồi sử dụng findFoodById() để tìm vị trí của food=> xoá food tìm thấy
    public void removeFoodById() {
//        while (true) {
        String newId = MyLib.getAString("Input id to remove: ", "The ID following Fxxx format, x is the digits!", "^[f,F]{1}[0-9]{3}$").toUpperCase().trim();
        Food food = findFoodbyId(newId);
        if (food == null) {
            System.out.println("The food is not existed!");
//                continue;                
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equalsIgnoreCase(newId)) {
                list.remove(i);
                System.out.println("The food has been removed!");
            }
        }
//            break;
//        }
    }

//in danh sách food ra màn hình dựa vào ngày hết hạn giảm dần
    public void displayFood() {
        System.out.println("                    ===THE LIST FOOD BASED ON A DESCENDING EXPIRATION DATE===");
        System.out.println("|   ID   |           NAME           |   WEIGHT    |      TYPE      |    PLACE   |     EXPIRED DATE     |");
        Collections.sort(list);
        list.forEach(food -> {
            food.outputFood();
        });
        if (list.size() == 1) {
            System.out.println("Total " + list.size() + " Food.");
        }
        if (list.size() > 1) {
            System.out.println("Total " + list.size() + " Foods.");
        }
    }

//ghi danh sách food thành file binary
    public void storyFileFood(){
        tf.storyFile(list);
    }

}
