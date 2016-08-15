package src.main.java.controllers;

import src.main.java.guis.SalePanelUI;
import src.main.java.product.Jewelry;
import src.main.java.product.Product;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 19.07.2016.
 */
public class AddItemToSale implements ActionListener {

    private ShopStore shopStore;
    private Service serv;
    private List<Product> list;
    private SalePanelUI spUI;


    public AddItemToSale(ShopStore shopStore, Service serv, SalePanelUI spUI) {
        this.shopStore = shopStore;
        this.serv = serv;
        this.spUI = spUI;
        this.list = new ArrayList<Product>(shopStore.getiDBm().getProductMap().values());
    }

    public Service getServ() {
        return serv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Jewelry item = null;
        for(int i = 0; i < list.size(); i++){
            if(spUI.getChoosedProduct().equals(((Jewelry)list.get(i)).getArticul())){
                item = ((Jewelry)list.get(i));
                item.setCount(Integer.parseInt(spUI.getProductsQuant()));
            }
        }
        serv.addJewelryItems(item);
        for(int i = 0; i < serv.getJewelryItems().size(); i++){
            spUI.setTextArea(serv.getJewelryItems().get(i).toString() + ", ");
        }

        double outcome = 0.0;
        for(Jewelry jew : serv.getJewelryItems()){
            outcome += jew.calcValue() * Integer.parseInt(spUI.getProductsQuant());
        }
        spUI.setTextValue(outcome);

        spUI.setTfQuant("0");

    }
}
