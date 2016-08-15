package src.main.java.controllers;

import src.main.java.guis.SetNewQuantityPanel;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 18.07.2016.
 */
public class SetNewQuantity implements ActionListener {

    private ShopStore shop;
    private Service serv;
    private SetNewQuantityPanel nqPUI;
    //private JewGUI jewGUI;

    public SetNewQuantity(ShopStore shop, Service serv, SetNewQuantityPanel nqPUI){
        this.shop = shop;
        this.serv = serv;
        this.nqPUI = nqPUI;
        //this.jewGUI = jewGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String articul = nqPUI.getArticul();
        int neoQuant = nqPUI.getNewQuantity();
        shop.changeProductsQuantity(articul, neoQuant);
        JOptionPane.showConfirmDialog(null, "Новое количество товара успешно занесено в базу",
                "Сообщение базы данных", JOptionPane.PLAIN_MESSAGE);
    }
}
