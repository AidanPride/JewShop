package src.main.java.controllers;

import src.main.java.guis.SalePanelUI;
import src.main.java.product.Jewelry;
import src.main.java.product.Product;
import src.main.java.shop.Sale;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prulov on 19.07.2016.
 */
public class SaleController implements ActionListener{

    private ShopStore shop;
    private AddItemToSale adItSale;
    private SalePanelUI spUI;

    public SaleController(ShopStore shop, AddItemToSale adItSale, SalePanelUI spUI) {

        this.shop = shop;
        this.adItSale = adItSale;
        this.spUI = spUI;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Sale sale = new Sale();
        sale.setId(shop.getiDBm().getSales().size() + 1);
        sale.setDate(spUI.getDate());
        sale.setBuyer(spUI.getSelectedBuyer());

        for (Product prod : shop.getiDBm().getProductMap().values()) {
            for (Jewelry jew : adItSale.getServ().getJewelryItems()) {

                if (((Jewelry) prod).getArticul().equals(jew.getArticul()) &&
                        ((Jewelry) prod).getQuantity() >= jew.getQuantity()) {

                    JOptionPane.showConfirmDialog(null, "Transaction is possible!", "Transaction possibility", JOptionPane.PLAIN_MESSAGE);
                    sale.setJewelries(adItSale.getServ().getJewelryItems());
                    System.out.println(jew.getQuantity());
                    shop.getiDBm().soldJewelryMinus(jew, jew.getCount());
                    shop.addSaleTransaction(sale);

                } else if (((Jewelry) prod).getArticul().equals(jew.getArticul()) &&
                        ((Jewelry) prod).getQuantity() < jew.getQuantity()) {

                    JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try again with new quantity of item",
                            "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);

                } else {

                    JOptionPane.showConfirmDialog(null, "Transaction is NOT possible! \n Please, try another articul",
                            "Transaction possibility", JOptionPane.OK_CANCEL_OPTION);
                }
            }
        }
        adItSale.getServ().clearJewelryItems();
    }

}
