package src.main.java.product;


import java.io.Serializable;

public class Ingridient implements Serializable{

    private String articul;
    private String name;
    private double price;
    private int count;

    public Ingridient() {
    }

    public Ingridient(String articul, String name, int count, double price) {

        this.articul = articul;
        this.name = name;
        this.count = count;
        this.price = price;
        this.price = calcPrice();

    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public double calcPrice() {
        return getPrice() * getCount();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String ingridientShow(){

        return getArticul() + ", " + getName() + " (" + getCount() + "x" + getPrice() + ")= " + calcPrice();
    }

    public String toString(){

        return getArticul() + ", " + getName() + " - " + getCount();
    }
}
