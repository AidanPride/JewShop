package src.main.java.service;

import src.main.java.product.Ingridient;
import src.main.java.product.Jewelry;
import src.main.java.shop.ShopStore;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private ShopStore shopStore;
    private List<Ingridient> ingridients;
    private List<Jewelry> jewlryItems;

    public Service(ShopStore shopStore) {

        this.shopStore = shopStore;
        ingridients = new ArrayList<>();
        jewlryItems = new ArrayList<>();
    }

    public void prodMapShow() {

        System.out.println();
        System.out.println("------------------------------------------------- JEWERLY SHOP \"NATALI\" JEWERLY SHOP ------------------------------------------|");
        System.out.println("__________________________________________________________________________________________________________________________________");
        System.out.printf("%-1s%-45s%-65s%-10s%-15s%n", "# ", "|      Name of product", "|      Ingredients, name (quantity x price)=prime cost,",
                "|Total prime cost", "|");
        System.out.println("__________________________________________________________________________________________________________________________________");

        int i = 0;
        for (Object prod : getShopStore().getProductMap().values()) {
            if (prod != null) {
                i++;
                System.out.print(i);
                ((Jewelry)prod).productInfoShow();
            }
        }
        System.out.println("_________________________________________________________________________________________________________________________________|");
        System.out.println();
    }

    public void addIngridients(Ingridient ingridient){

        ingridients.add(ingridient);

    }

    public void addJewelryItems(Jewelry jew){

        jewlryItems.add(jew);

    }

    public ShopStore getShopStore() {
        return shopStore;
    }

    public List<Ingridient> getIngridients() {
        return new ArrayList<>(ingridients);
    }

    public List<Jewelry> getJewelryItems(){return new ArrayList<>(jewlryItems);}

    public void clearIngridients() {
        ingridients.clear();
    }

    public void clearJewelryItems() {
        jewlryItems.clear();
    }
}
