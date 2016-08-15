package src.main.java.dbmanagers;

import src.main.java.clients.Buyer;
import src.main.java.product.Ingridient;
import src.main.java.product.Product;
import src.main.java.shop.Sale;

import java.util.List;
import java.util.Map;

/**
 * Created by prulov on 14.07.2016.
 */
public interface IDBMInterface {

    // get data
    Map<String, Product> getProductMap();
    List<Ingridient> getIngridients();
    List<Buyer> getBuyers();
    List<Sale> getSales();

    // methods
    Map<String, Product> updateProductMap(String articul, Product product);

    Map<String, Product> changeQuantity(String articul, int neoQuant);

    // sale transaction
    List<Sale> updateSales(Sale sale);
    void soldJewelryMinus(Product product, int quant);


}
