package src.main.java.shop;

import src.main.java.clients.Buyer;
import src.main.java.dbmanagers.IDBMInterface;
import src.main.java.product.Ingridient;
import src.main.java.product.Product;

import java.util.*;

public class ShopStore <T> {

    private IDBMInterface iDBm;

    private Map<String, Product> productMap;
    private List<Ingridient> ingidients;
    private List<Buyer> buyers;
    private List<Sale> sales;

    public ShopStore() {

        this.productMap = new HashMap<>();
        this.ingidients = new ArrayList<>();
        this.buyers = new ArrayList<>();
        this.sales = new LinkedList<>();
    }


    // settings

    public IDBMInterface getiDBm() {
        return iDBm;
    }

    public void setiDBmI(IDBMInterface iDBm) {
        this.iDBm = iDBm;
    }


    // data

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }

    public List<Ingridient> getIngidients() {
        return new ArrayList<>(ingidients);
    }

    public void setIngidients(List<Ingridient> ingidients) {
        this.ingidients = ingidients;
    }

    public List<Buyer> getBuyers() {
        return new ArrayList<>(buyers);
    }

    public List<Sale> getSales() {
        return new LinkedList<>(sales);
    }

    public void setSales(List<Sale> history) {
        this.sales = history;
    }


    // business
    public void addNewProduct(String articul, Product product){

        productMap = iDBm.updateProductMap(articul, product);
        setProductMap(productMap);
    }

    public void changeProductsQuantity(String articul, int newQuant){

        productMap = iDBm.changeQuantity(articul, newQuant);
        setProductMap(productMap);
    }

    public void addSaleTransaction(Sale sale){

        sales = iDBm.updateSales(sale);
        setSales(sales);
    }
}
