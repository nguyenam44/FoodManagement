/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation.file;

import dto.Food;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author macos
 */
public class TextFactoryFile {
        private final String foodFileName = "food.dat";
        
//ghi danh sách vào file binary
   public void storyFile(ArrayList<Food> list) {

        try {
            try ( FileOutputStream file = new FileOutputStream(foodFileName);  ObjectOutputStream oStream = new ObjectOutputStream(file)) {
                for (Food obj : list) {
                    oStream.writeObject(obj);
                }
            }
            System.out.println("Store to file successfully!");
        } catch (IOException ex) {
        }
    }

   //đọc file food.dat
      public void readInjectionFromBinaryFile(ArrayList<Food> list) throws Exception {
        ObjectInputStream ois = null;
        try ( FileInputStream fis = new FileInputStream(foodFileName)) {
            ois = new ObjectInputStream(fis);
            Object obj;
            while ((obj = ois.readObject()) != null) {
                if (obj instanceof Food) {
                    list.add((Food) obj);
                }
            }
            fis.close();
            ois.close();
        } catch (EOFException e) {
        } catch (IOException ex) {
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
