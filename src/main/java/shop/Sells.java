package shop;

import clients.Buyer;
import product.Product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Sells implements Serializable{
    List<Product> product;
    Date date;
    Buyer buyer;

    public Sells() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
