package shop;


import product.Product;

import java.util.Map;

public class ShopStore <T> {
    private Map<String , Product> productMap;

    public ShopStore() {
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }
}
