package src.main.java.controllers;

import src.main.java.guis.AddNewProductPanelUI;
import src.main.java.product.Ingridient;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by prulov on 03.07.2016.
 */
public class AddIngridientsToProduct implements ActionListener {

    private ShopStore shopStore;
    private Service serv;
    private List<Ingridient> list;
    private AddNewProductPanelUI anpUI;


    public AddIngridientsToProduct(ShopStore shopStore, Service serv, AddNewProductPanelUI anpUI) {
        this.shopStore = shopStore;
        this.serv = serv;
        this.anpUI = anpUI;
        this.list = shopStore.getiDBm().getIngridients();
    }

    public Service getServ() {
        return serv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Ingridient item = null;
        for(int i = 0; i < list.size(); i++){
            if(anpUI.getChoosedIngridient().equals(list.get(i).getArticul())){
                item = list.get(i);
                item.setCount(Integer.parseInt(anpUI.getIngridientsQuant()));
            }
        }
        serv.addIngridients(item);
        for(int i = 0; i < serv.getIngridients().size(); i++){
            anpUI.setTextArea(serv.getIngridients().get(i).ingridientShow() + ", ");
        }

        double outcome = 0.0;
        for(Ingridient ingr : serv.getIngridients()){
            outcome += ingr.calcPrice();
        }
        anpUI.setTextPrimeCost(outcome);
    }

}
