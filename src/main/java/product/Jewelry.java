package src.main.java.product;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Jewelry implements Product, Serializable {

    private Types type;
    private String articul;
    private String name;
    private List<Ingridient> ingridients;
    private double primeCost;
    private double value;
    private int quantity;
    private int count;
    private Colors color;
    private Image img;

    public Jewelry() {
    }

    public Jewelry(String articul, Types type, String name, List<Ingridient> ingridients, Colors color) {

        this.articul = articul;
        this.type = type;
        this.name = name;
        this.ingridients = ingridients;
        this.count = count;
        this.primeCost = calcPrice();
        this.color = color;
        this.img = img;
        this.quantity = quantity;
        this.value = calcValue();
    }

    public double  calcPrice() {

        double result = 0.0;
        for (Ingridient ingr : ingridients) {
            result += ingr.calcPrice();
        }
        return result;
    }

    public double calcValue(){

        double result = calcPrice() * 1.5;
        return result;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<Ingridient> ingridients) {
        this.ingridients = ingridients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(double primeCost) {
        this.primeCost = primeCost;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void productInfoShow(){

        System.out.printf("%-1s%-45s%-65s%-10s%-15s%n", " ", "|"+getArticul()+", "+getName(), "|" + prodIngrsShow(), "|    UAH " + getPrimeCost(), "   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }

    public String prodIngrsShow(){

        String result = "";
        for (Ingridient ingr : ingridients){
            result += ingr.ingridientShow() + ", ";
        }
        return result;
    }

    public String toString(){

        return getType()+ ", " + getArticul() + ", " +  getName() + ", " +  getValue() + " - " + getCount();
    }


}
