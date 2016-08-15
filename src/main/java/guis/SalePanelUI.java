package src.main.java.guis;

import src.main.java.clients.Buyer;
import src.main.java.controllers.AddItemToSale;
import src.main.java.controllers.SaleController;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prulov on 03.07.2016.
 */
public class SalePanelUI {

    private ShopStore shopStore;
    private Service serv;
    private AddItemToSale adItToSale;
    private JPanel salePanel;


    private List<Buyer> buyers = new ArrayList<>();

    // control's fields for SalePanel:
    private JTextField tfDate;
    private JTextField tfArticul;
    private JFormattedTextField tfQuant;
    private JFormattedTextField tfValue;
    private JComboBox comboBuyers;

    private JButton addToBasket;
    private JButton sell;
    private JTextArea area;

    public SalePanelUI(ShopStore shopStore, Service serv){
        this.shopStore = shopStore;
        this.serv = serv;
        adItToSale = new AddItemToSale(shopStore, serv, this);
        this.salePanel = createSalePanel();
    }

    public JPanel createSalePanel() {

        salePanel = new JPanel();
        salePanel.setLayout(new GridBagLayout());
        salePanel.setBackground(Color.BLACK);

        //buyers = initBuyersList();
        buyers = shopStore.getiDBm().getBuyers();

        Border matte = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border titled = BorderFactory.createTitledBorder(matte, "НОВАЯ ПРОДАЖА", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 24), Color.BLUE);
        salePanel.setBorder(titled);

        NumberFormat nf = NumberFormat.getInstance();
        NumberFormat formatter = new DecimalFormat("#0.00");

        JLabel date = new JLabel("Дата продажи:");
        date.setFont(new Font("Garamond", Font.BOLD, 20));
        date.setForeground(Color.RED);
        salePanel.add(date, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfDate = new JTextField();
        tfDate.setFont(new Font("Garamond", Font.BOLD, 20));
        tfDate.setForeground(Color.BLACK);
        tfDate.setColumns(6);
        tfDate.setHorizontalAlignment(JTextField.RIGHT);
        tfDate.setText(dateFormat(new Date(System.currentTimeMillis())));
        salePanel.add(tfDate, new GridBagConstraints(1, 0, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel buyer = new JLabel("Выберите, пожалуйста, Клиента из списка:");
        buyer.setFont(new Font("Garamond", Font.BOLD, 20));
        buyer.setForeground(Color.RED);
        salePanel.add(buyer, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        comboBuyers = new JComboBox(new BuyerComboBoxModel(buyers));
        comboBuyers.setFont(new Font("Garamond", Font.BOLD, 20));
        comboBuyers.setForeground(Color.BLACK);
        salePanel.add(comboBuyers, new GridBagConstraints(0, 2, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel good = new JLabel("Введите, пожалуйста, артикул выбранного Товара:");
        good.setFont(new Font("Garamond", Font.BOLD, 20));
        good.setForeground(Color.RED);
        salePanel.add(good, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfArticul = new JTextField();
        tfArticul.setFont(new Font("Garamond", Font.BOLD, 20));
        tfArticul.setForeground(Color.BLACK);
        tfArticul.setColumns(15);
        tfArticul.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfArticul, new GridBagConstraints(0, 4, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        area = new JTextArea(5, 20);
        area.setEditable(false);
        area.setFont(new Font("Garamond", Font.BOLD, 15));
        area.setForeground(Color.BLACK);
        salePanel.add(area, new GridBagConstraints(3, 1, 6, 5, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quantity = new JLabel("Количество, шт.:");
        quantity.setFont(new Font("Garamond", Font.BOLD, 20));
        quantity.setForeground(Color.RED);
        salePanel.add(quantity, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setValue(1);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfQuant, new GridBagConstraints(1, 5, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        addToBasket = new JButton("Добавить в корзину");
        addToBasket.setFont(new Font("Garamond", Font.BOLD, 20));
        addToBasket.setForeground(Color.GREEN);
        salePanel.add(addToBasket, new GridBagConstraints(3, 6, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        addToBasket.addActionListener(new AddItemToSale(shopStore, serv, this));

        sell = new JButton("Завершить продажу");
        sell.setFont(new Font("Garamond", Font.BOLD, 20));
        sell.setForeground(Color.BLUE);
        sell.setBorder(empty);
        salePanel.add(sell, new GridBagConstraints(0, 7, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        sell.addActionListener(new SaleController(shopStore, adItToSale, this));

        JLabel value = new JLabel("Стоимость покупки, грн.:");
        value.setFont(new Font("Garamond", Font.BOLD, 20));
        value.setForeground(Color.RED);
        salePanel.add(value, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfValue = new JFormattedTextField(formatter);
        tfValue.setFont(new Font("Garamond", Font.BOLD, 20));
        tfValue.setForeground(Color.BLACK);
        tfValue.setValue(0);
        tfValue.setHorizontalAlignment(JTextField.RIGHT);
        salePanel.add(tfValue, new GridBagConstraints(1, 6, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        // adding monoTable

//        JTable monoSale = new JTable();
//        salePanel.add(monoSale, new GridBagConstraints(0, 8, 4, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        return salePanel;
    }

//    public List<Buyer> initBuyersList(){
//        List<String> list = new ArrayList<>();
//        for(Buyer buyer : shopStore.getiDBm().getBuyers()){
//            list.add(buyer.toString());
//        }
//        return list;
//    }

    public String dateFormat(Date d) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(d);
    }

    public JTextField getTfDate() {
        return tfDate;
    }

    public String getDate(){

        return getTfDate().getText();
    }

    public JComboBox getComboBuyers() {
        return comboBuyers;
    }

    public Buyer getSelectedBuyer(){

        return (Buyer) getComboBuyers().getSelectedItem();
    }

    public JTextArea getArea() {
        return area;
    }

    public void setTextArea(String str){

        str = "";
        for(int i = 0; i < serv.getJewelryItems().size(); i++){
            str += serv.getJewelryItems().get(i).toString() + ",\n";
        }
        getArea().setText(str);
    }

    public JFormattedTextField getTfValue() {
        return tfValue;
    }

    public String getValue() {
        return getTfValue().getText();
    }

    public JTextField getTfArticul() {
        return tfArticul;
    }

    public String getChoosedProduct(){

        return getTfArticul().getText();
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public String getProductsQuant(){
        return getTfQuant().getText();
    }

    public void setTfQuant(String str){
        getTfQuant().setText(str);
    }

    public void setTextValue(double sum){

        getTfValue().setText(String.valueOf(sum));
    }
}
