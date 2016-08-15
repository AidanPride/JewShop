package src.main.java.guis.tables;

import src.main.java.product.Ingridient;
import src.main.java.product.Jewelry;
import src.main.java.product.Product;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.util.List;

/**
 * Created by prulov on 09.07.2016.
 */
public class TablePriceList {

    private ShopStore shop;
    private JTable table;
    private int columns;

    public TablePriceList(ShopStore shop){

        this.shop = shop;
        columns = 9;
        this.table = createPriceListTable();
        table.setFillsViewportHeight(true);
    }

    public JTable createPriceListTable() {

        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable priceList = new JTable(data, colNames);
        priceList.setAutoCreateRowSorter(false);
        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = priceList.getColumnModel().getColumn(i);
            if(i == 0 || i == 1 || i == 2) {
                column.setPreferredWidth(30);
            }else if(i == 3){
                column.setPreferredWidth(180);
            }else if(i == 5){
                column.setPreferredWidth(420);
            }else if(i == 4){
                column.setPreferredWidth(120);
            }else{
                column.setPreferredWidth(60);
            }
        }
        return priceList;
    }

    private Object[] fillColumns() {

        String[] heads = new String[]{
                "#", "Type", "Articul", "Image", "Name", "Ingridients", "Value, UAH",  "Quantity", "Color"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

    private Object[][] fillData() {

        Object[][] data = new Object[shop.getiDBm().getProductMap().size()][columns];
        int j = 1, i = 0;

        for (Product product : shop.getiDBm().getProductMap().values()){

            data[i] = new Object[]{
                    j++,
                    ((Jewelry) product).getType(),
                    ((Jewelry) product).getArticul(),
                    ((Jewelry) product).getImg(),
                    ((Jewelry) product).getName(),
                    ingrInfoString(((Jewelry) product).getIngridients()),
                    ((Jewelry) product).getValue(),
                    ((Jewelry) product).getQuantity(),
                    ((Jewelry) product).getColor()
            };
            i++;
        }
        return data;
    }

    private Object ingrInfoString(List<Ingridient> ingrs){

        Object ingrInfo = null;
        for(Ingridient ingr : ingrs){
            ingrInfo += ingr.toString() + " | ";
        }
        return ingrInfo;
    }

}
