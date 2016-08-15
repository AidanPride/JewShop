package src.main.java.controllers;

import src.main.java.guis.AddNewProductPanelUI;
import src.main.java.product.Colors;
import src.main.java.product.Jewelry;
import src.main.java.product.Product;
import src.main.java.product.Types;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by prulov on 02.07.2016.
 */
public class AddNewProduct implements ActionListener {

    private ShopStore shSt;
    private AddIngridientsToProduct aItProd;
    private AddNewProductPanelUI anpUI;

    public AddNewProduct(ShopStore shSt, AddIngridientsToProduct aItProd, AddNewProductPanelUI anpUI) {

        this.shSt = shSt;
        this.aItProd = aItProd;
        this.anpUI = anpUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Jewelry novus = new Jewelry();
        novus.setArticul(anpUI.getArticul());
        if(anpUI.getSelectedTypes().equals("BAND")){
            novus.setType(Types.BAND);
        }else if(anpUI.getSelectedTypes().equals("CHAPLET")){
            novus.setType(Types.CHAPLET);
        }else if(anpUI.getSelectedTypes().equals("EARRINGS")) {
            novus.setType(Types.EARRINGS);
        }else{
            novus.setType(Types.PENDANT);
        }
        novus.setName(anpUI.getName());

        novus.setIngridients(aItProd.getServ().getIngridients());

        if(anpUI.getSelectedColors().equals("GOLD")){
            novus.setColor(Colors.GOLD);
        }else if(anpUI.getSelectedColors().equals("SILVER")){
            novus.setColor(Colors.SILVER);
        }else{
            novus.setColor(Colors.BRONZE);
        }

        novus.setPrimeCost(novus.calcPrice());
        novus.setValue(novus.calcValue());

        Product product = novus;
        shSt.addNewProduct(anpUI.getArticul(), product);
        aItProd.getServ().clearIngridients();
        JOptionPane.showConfirmDialog(null, "Новый продукт был успешно добавлен в базу!",
                "Сообщение базы данных", JOptionPane.PLAIN_MESSAGE);
    }

}