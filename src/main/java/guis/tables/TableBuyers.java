package src.main.java.guis.tables;

import src.main.java.clients.Buyer;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * Created by prulov on 19.07.2016.
 */
public class TableBuyers {

    private ShopStore shop;
    private JTable table;
    private int columns;

    public TableBuyers(ShopStore shop){

        this.shop = shop;
        columns = 6;
        this.table = createBuyerTable();
        table.setFillsViewportHeight(true);
    }

    public JTable createBuyerTable() {

        Object[] colNames = fillColumns();
        Object[][] data = fillData();

        JTable priceList = new JTable(data, colNames);
        priceList.setAutoCreateRowSorter(false);
        TableColumn column = null;
        for(int i = 0; i < columns; i++){
            column = priceList.getColumnModel().getColumn(i);
            if(i == 4) {
                column.setPreferredWidth(420);
            }else{
                column.setPreferredWidth(60);
            }
        }
        return priceList;
    }

    private Object[] fillColumns() {

        String[] heads = new String[]{
                "#", "Personal ID", "Name", "Region", "Way of sale", "Manager"};
        Object[] colNames = new Object[heads.length];
        for(int i = 0; i < columns; i++){
            colNames[i] = heads[i];
        }
        return colNames;
    }

    private Object[][] fillData() {

        Object[][] data = new Object[shop.getiDBm().getBuyers().size()][columns];
        int j = 1, i = 0;

        for (Buyer buyer : shop.getiDBm().getBuyers()){

            data[i] = new Object[]{
                    j++,
                    buyer.getId(),
                    buyer.getName(),
                    buyer.getRegion(),
                    buyer.getWaysOfSells(),
                    buyer.getManager().toString()
            };
            i++;
        }
        return data;
    }

}
