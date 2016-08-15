package src.main.java;

import src.main.java.dbmanagers.DB_Manager;
import src.main.java.shop.ShopStore;
import src.main.java.guis.JewGUI;

public class Launcher {

    public static void main(String[] args) {

        ShopStore shopStore = new ShopStore();
        shopStore.setiDBmI(new DB_Manager());
        new JewGUI(shopStore);
    }
}
