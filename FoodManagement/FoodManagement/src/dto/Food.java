/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author macos
 */
public class Food implements Comparable<Food>, Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected String name;
    protected double weight;
    protected String type;
    protected String place;
    private String expiredDate;

    public Food() {
        id="";
        name="";
        weight=0;
        type="";
        place="";
        expiredDate="";
    }

    public Food(String id, String name, double weight, String type, String place, String expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getPlace() {
        return place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
    //in ra thông tin food
    public void outputFood() {
        String unit = "";
        if (type.equalsIgnoreCase("GAS DRINK") || type.equalsIgnoreCase("ACOHOLIC DRINK") || type.equalsIgnoreCase("COMMON DRINK")) {
            unit = weight + "l";
        }
        if (type.equalsIgnoreCase("FRESH FOOD") || type.equalsIgnoreCase("FAST FOOD")) {
            unit = weight + "kg";
        }
        System.out.printf("|  %-6s| %-25s| %-12s| %-15s| %-11s| %-21s|\n", id, name, unit, type, place, expiredDate);
        
    }

//    public void outputFoodByName() {
//        String unit="";
//        if (type.equalsIgnoreCase("GAS DRINK") || type.equalsIgnoreCase("ACOHOLIC DRINK") || type.equalsIgnoreCase("COMMON DRINK")) {
//            unit = weight + "l";
//        }
//        if (type.equalsIgnoreCase("FRESH FOOD") || type.equalsIgnoreCase("FAST FOOD")) {
//            unit = weight + "kg";
//        }
//        System.out.println("ID: " + id + " |WEIGHT: " + unit + " |TYPE: " + type + " |PLACE: " + place + " |EXPIRED DATE: " + expiredDate);
//    }
    @Override
    //sắp xếp food theo ngày hết hạn giảm dần
    public int compareTo(Food o) {
        int d1 = Integer.parseInt(expiredDate.substring(0, 2));
        int m1 = Integer.parseInt(expiredDate.substring(3, 5));
        int y1 = Integer.parseInt(expiredDate.substring(6));

        int d2 = Integer.parseInt(o.expiredDate.substring(0, 2));
        int m2 = Integer.parseInt(o.expiredDate.substring(3, 5));
        int y2 = Integer.parseInt(o.expiredDate.substring(6));

        if (y1 != y2) {
            return y2 - y1;
        } else if (m1 != m2) {
            return m2 - m1;
        } else {
            return d2 - d1;
        }
    }

}
