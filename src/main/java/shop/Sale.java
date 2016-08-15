package src.main.java.shop;

import src.main.java.clients.Buyer;
import src.main.java.product.Jewelry;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sale implements Serializable{

    private long id;
    private String date = dateFormat(new Date(System.currentTimeMillis()));
    private List<Jewelry> jewelries;
    private Buyer buyer;

    public Sale() {
    }

    public Sale(long id, String date, List<Jewelry> jewelries, Buyer buyer) {
        this.id = id;
        this.date = date;
        this.jewelries = new ArrayList<Jewelry>(jewelries);
        this.buyer = buyer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Jewelry> getJewelries() {
        return jewelries;
    }

    public void setJewelries(List<Jewelry> jewelries) {
        this.jewelries = jewelries;
    }

    public String dateFormat(Date d){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }
}
