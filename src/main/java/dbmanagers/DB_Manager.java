package src.main.java.dbmanagers;

import src.main.java.clients.Buyer;
import src.main.java.clients.Manager;
import src.main.java.clients.Region;
import src.main.java.clients.WaysOfSells;
import src.main.java.product.Ingridient;
import src.main.java.product.Jewelry;
import src.main.java.product.Product;
import src.main.java.shop.Sale;

import java.util.*;

/**
 * Created by prulov on 14.07.2016.
 */
public class DB_Manager implements IDBMInterface {

    private Map<String, Product> productMap;
    private List<Ingridient> ingridients;
    private List<Buyer> buyers;
    private List<Sale> sales;

    public DB_Manager(){

        this.productMap = new HashMap<>();
        ingridients = new ArrayList<>();
        this.ingridients = initListOfIngridients();
        buyers = new ArrayList<>();
        this.buyers = initListOfBuyers();
        sales = new LinkedList<>();
    }


    // data

    @Override
    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {this.productMap = productMap;}

    @Override
    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<Ingridient> ingridients) {
        this.ingridients = ingridients;
    }

    @Override
    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    @Override
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    // business

    @Override
    public Map<String, Product> updateProductMap(String articul, Product product){

        productMap.put(articul, product);
        return productMap;
    }

    @Override
    public Map<String, Product> changeQuantity(String articul, int neoQuant) {

        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            if (entry.getKey().equals(articul)) {
                ((Jewelry) entry.getValue()).setQuantity(neoQuant);
            }
        }
        return productMap;
    }

    @Override
    public List<Sale> updateSales(Sale sale){
        sales.add(sale);
        return sales;
    }

    @Override
    public void soldJewelryMinus(Product product, int quant) {

        Jewelry sold = null;
        for(Product jew : productMap.values()){
            if(jew.equals(product)){
                sold = (Jewelry)jew;
                break;
            }
        }
        sold.setQuantity(sold.getQuantity() - quant);
    }

    private List<Ingridient> initListOfIngridients(){

        List<Ingridient> list = new ArrayList<>();
        list.add(new Ingridient("I001", "Gold", 1, 72.4));
        list.add(new Ingridient("I002", "Stone", 1, 34.5));
        list.add(new Ingridient("I003", "Silver", 1, 14.5));
        list.add(new Ingridient("I004", "Bronze", 1, 4.5));
        list.add(new Ingridient("I005", "Glass", 1, 2.6));
        return list;
    }

    private List<Buyer> initListOfBuyers(){

        List<Buyer> list = new ArrayList<>();
        list.add(new Buyer(1, "Zima, Ltd", Region.KIEV, WaysOfSells.DISTRIBUTION, new Manager(1, "Starikova", "Inna")));
        list.add(new Buyer(2, "Leto, Ltd", Region.EAST, WaysOfSells.DISTRIBUTION, new Manager(2, "Kurko", "Anna")));
        list.add(new Buyer(3, "Vesna, JSC", Region.WEST, WaysOfSells.RETAIL, new Manager(1, "Starikova", "Inna")));
        list.add(new Buyer(4, "Osen, Ltd", Region.CENTER, WaysOfSells.INTERNET, new Manager(3, "Yunakova", "Zhanna")));
        list.add(new Buyer(5, "Season, PJSC", Region.SOUTH, WaysOfSells.INTERNET, new Manager(4, "Ryabchenko", "Olga")));
        return list;
    }

}
