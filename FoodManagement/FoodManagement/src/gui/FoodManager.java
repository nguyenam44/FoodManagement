/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.FoodList;
import java.util.logging.Level;
import java.util.logging.Logger;
import validation.MyLib;

/**
 *
 * @author macos
 */
public class FoodManager {

    public static void main(String[] args) {
        try {
            int choice;
            boolean cont;
            FoodList list = new FoodList();
            do {
                
                System.out.println("\nWelcome to Food Management - @ 2021 by <SE150925 - Nguyễn Văn Hải Nam>");
                System.out.println("Select the options below: ");
                System.out.println("1. Add a new food");
                System.out.println("2. Search a food by name");
                System.out.println("3. Remove a food by ID");
                System.out.println("4. Print the food list in the descending order of expired date");
                System.out.println("5. Store the food list to binary file");
                System.out.println("6. Exit");
                choice = MyLib.getChoice("Input your choice: ", "Only choice [1-6]", 1, 6);
                switch (choice) {
                    case 1 -> {
                        do {
                            System.out.println("\n==> You choose ADD a new food");
                            System.out.println("1. Add a new eating");
                            System.out.println("2. Add a new drinking");
                            choice = MyLib.getChoice("Input your choice: ", "Only choice [1-2]", 1, 2);
                            cont = false;
                            switch (choice) {
                                case 1 -> {
                                    System.out.println("\n==> You choose add a new eating");
                                    list.addEating();
                                }
                                case 2 -> {
                                    System.out.println("\n==> You choose add a new drinking");
                                    list.addDrinking();
                                }
                            }
                        } while (cont);
                    }
                    case 2 -> {
                        if (list.getSize() == 0) {
                            System.out.println("The food list is empty!");
                            break;
                        }
                        System.out.println("\n==> You choose search a food by name");
                        list.searchFoodByName();
                    }
                    case 3 -> {
                        if (list.getSize() == 0) {
                            System.out.println("The food list is empty!");
                            break;
                        }
                        System.out.println("\n==> You choose remove a food by name");
                        list.displayFood();
                        list.removeFoodById();
                    }
                    case 4 -> {
                        if (list.getSize() == 0) {
                            System.out.println("The food list is empty!");
                            break;
                        }
                        System.out.println("\n==> You choose print the food list in the descending order of expired date");
                        list.displayFood();
                    }
                    case 5 -> {
                        System.out.println("\n==> You choose store the food list to binary file");
                        list.storyFileFood();
                    }
                        
                    default -> System.out.println("\nTHANK YOU!!!");
                }
            } while (choice > 0 && choice < 6);
        } catch (Exception ex) {
            Logger.getLogger(FoodManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
