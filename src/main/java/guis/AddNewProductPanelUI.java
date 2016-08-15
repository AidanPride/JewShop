package src.main.java.guis;

import src.main.java.controllers.AddIngridientsToProduct;
import src.main.java.controllers.AddNewProduct;
import src.main.java.product.Colors;
import src.main.java.product.Types;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 03.07.2016.
 */
public class AddNewProductPanelUI {

    private ShopStore shopStore;
    private Service serv;
    private AddIngridientsToProduct aItoProd;
    private JPanel anpPanel;

    // data
    private List<String> types;
    private List<String> colors;

    // control's fields
    private JTextField tfArticul;
    private JTextField tfImg;
    private JTextField tfName;
    private JTextField tfChoose;
    private JFormattedTextField tfQuant;
    private JTextArea area;
    private JTextField tfPrimeCost;

    private JComboBox comboTypes;
    private JComboBox comboColors;

    private JButton addIngridient;
    private JButton addNewProd;


    public AddNewProductPanelUI(ShopStore shopStore, Service serv){
        this.shopStore = shopStore;
        this.serv = serv;
        aItoProd = new AddIngridientsToProduct(shopStore, serv, this);
        this.anpPanel = createAddNewProductPanel();
    }

    private JPanel createAddNewProductPanel() {

        types = initTypesList();
        colors = initColorsList();

        anpPanel = new JPanel();
        anpPanel.setLayout(new GridBagLayout());
        anpPanel.setBackground(Color.BLACK);

        Border matte = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.ORANGE);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border titled = BorderFactory.createTitledBorder(matte, "CREATE NEW PRODUCT", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 24), Color.ORANGE);
        anpPanel.setBorder(titled);

        NumberFormat nf = NumberFormat.getInstance();

        JLabel head = new JLabel("<html>ДОБАВЛЕНИЕ В АССОРТИМЕНТ<br>НОВОГО ПРОДУКТА:");
        head.setFont(new Font("Garamond", Font.BOLD, 20));
        head.setForeground(Color.ORANGE);
        anpPanel.add(head, new GridBagConstraints(1, 0, 4, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel articul = new JLabel("Артикул:");
        articul.setFont(new Font("Garamond", Font.BOLD, 20));
        articul.setForeground(Color.ORANGE);
        anpPanel.add(articul, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfArticul = new JTextField();
        tfArticul.setFont(new Font("Garamond", Font.BOLD, 20));
        tfArticul.setForeground(Color.BLACK);
        tfArticul.setColumns(15);
        tfArticul.setHorizontalAlignment(JTextField.RIGHT);
        anpPanel.add(tfArticul, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel img = new JLabel("Имидж:");
        img.setFont(new Font("Garamond", Font.BOLD, 20));
        img.setForeground(Color.ORANGE);
        anpPanel.add(img, new GridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfImg = new JTextField();
        tfImg.setFont(new Font("Garamond", Font.BOLD, 20));
        tfImg.setForeground(Color.BLACK);
        tfImg.setColumns(15);
        tfImg.setHorizontalAlignment(JTextField.RIGHT);
        tfImg.setText("null");
        anpPanel.add(tfImg, new GridBagConstraints(6, 1, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel type = new JLabel("Тип:");
        type.setFont(new Font("Garamond", Font.BOLD, 20));
        type.setForeground(Color.ORANGE);
        anpPanel.add(type, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        comboTypes = new JComboBox(new StringComboBoxModel(types));
        comboTypes.setFont(new Font("Garamond", Font.BOLD, 20));
        comboTypes.setForeground(Color.BLACK);
        anpPanel.add(comboTypes, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel name = new JLabel("Наименование:");
        name.setFont(new Font("Garamond", Font.BOLD, 20));
        name.setForeground(Color.ORANGE);
        anpPanel.add(name, new GridBagConstraints(5, 2, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfName = new JTextField();
        tfName.setFont(new Font("Garamond", Font.BOLD, 20));
        tfName.setForeground(Color.BLACK);
        tfName.setColumns(15);
        tfName.setHorizontalAlignment(JTextField.RIGHT);
        anpPanel.add(tfName, new GridBagConstraints(6, 2, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel color = new JLabel("Выбор цвета:");
        color.setFont(new Font("Garamond", Font.BOLD, 20));
        color.setForeground(Color.ORANGE);
        anpPanel.add(color, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        comboColors = new JComboBox(new StringComboBoxModel(colors));
        comboColors.setFont(new Font("Garamond", Font.BOLD, 20));
        comboColors.setForeground(Color.BLACK);
        anpPanel.add(comboColors, new GridBagConstraints(1, 3, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel ingridients = new JLabel("Добавление ингридиентов:");
        ingridients.setFont(new Font("Garamond", Font.BOLD, 20));
        ingridients.setForeground(Color.ORANGE);
        anpPanel.add(ingridients, new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel choose  = new JLabel();
        choose.setFont(new Font("Garamond", Font.BOLD, 15));
        choose.setForeground(Color.ORANGE);
        choose.setText("<html>Выбор ингридиентов<br>по артикулу:</html>");
        anpPanel.add(choose, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfChoose = new JTextField();
        tfChoose.setFont(new Font("Garamond", Font.BOLD, 15));
        tfChoose.setForeground(Color.BLACK);
        tfChoose.setColumns(15);
        tfChoose.setHorizontalAlignment(JTextField.RIGHT);
        anpPanel.add(tfChoose, new GridBagConstraints(1, 5, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel quant  = new JLabel();
        quant.setFont(new Font("Garamond", Font.BOLD, 15));
        quant.setForeground(Color.ORANGE);
        quant.setText("Количество ингридиентов:");
        anpPanel.add(quant, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfQuant = new JFormattedTextField(nf);
        tfQuant.setFont(new Font("Garamond", Font.BOLD, 15));
        tfQuant.setForeground(Color.BLACK);
        tfQuant.setColumns(15);
        tfQuant.setHorizontalAlignment(JTextField.RIGHT);
        tfQuant.setValue(1);
        anpPanel.add(tfQuant, new GridBagConstraints(1, 6, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        area = new JTextArea(5, 20);
        area.setEditable(false);
        area.setFont(new Font("Garamond", Font.BOLD, 15));
        area.setForeground(Color.BLACK);
        anpPanel.add(area, new GridBagConstraints(5, 5, 3, 3, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel primeCost = new JLabel("Себестоимость:");
        primeCost.setFont(new Font("Garamond", Font.BOLD, 15));
        primeCost.setForeground(Color.ORANGE);
        anpPanel.add(primeCost, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        tfPrimeCost = new JTextField();
        tfPrimeCost.setFont(new Font("Garamond", Font.BOLD, 20));
        tfPrimeCost.setForeground(Color.BLACK);
        tfPrimeCost.setColumns(15);
        tfPrimeCost.setHorizontalAlignment(JTextField.RIGHT);
        tfPrimeCost.setEditable(false);
        anpPanel.add(tfPrimeCost, new GridBagConstraints(1, 7, 2, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        addIngridient = new JButton("Добавить ингридиент");
        addIngridient.setFont(new Font("Garamond", Font.BOLD, 15));
        addIngridient.setForeground(Color.BLACK);
        addIngridient.setBackground(Color.orange);
        anpPanel.add(addIngridient, new GridBagConstraints(8, 7, 1, 1, 0, 0, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        addIngridient.addActionListener(aItoProd);

        addNewProd = new JButton("Добавить новый товар");
        addNewProd.setFont(new Font("Garamond", Font.BOLD, 20));
        addNewProd.setForeground(Color.BLACK);
        addNewProd.setBackground(Color.green);
        anpPanel.add(addNewProd, new GridBagConstraints(2, 8, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        addNewProd.setBorder(empty);
        addNewProd.addActionListener(new AddNewProduct(shopStore, aItoProd, this));

        return anpPanel;
    }

    private List<String> initColorsList() {
        colors = new ArrayList<>();
        for(Object str : Colors.values()){
            colors.add(str.toString());
        }
        return colors;
    }

    private List<String> initTypesList() {
        types = new ArrayList<>();
        for(Object str : Types.values()){
            types.add(str.toString());
        }
        return types;
    }

    public JTextArea getArea() {
        return area;
    }

    public void setTextArea(String str){

        str = "";
        for(int i = 0; i < serv.getIngridients().size(); i++){
            str += serv.getIngridients().get(i).ingridientShow() + ",\n";
        }
        getArea().setText(str);

    }

    public JComboBox getComboColors() {
        return comboColors;
    }

    public String getSelectedColors(){
        return getComboColors().getSelectedItem().toString();
    }

    public JComboBox getComboTypes() {
        return comboTypes;
    }

    public String getSelectedTypes(){
        return getComboTypes().getSelectedItem().toString();
    }

    public JTextField getTfArticul() {
        return tfArticul;
    }

    public String getArticul(){
        return getTfArticul().getText();
    }

    public JTextField getTfChoose() {
        return tfChoose;
    }

    public String getChoosedIngridient(){

        return getTfChoose().getText();
    }

    public JTextField getTfName() {
        return tfName;
    }

    public String getName(){
        return getTfName().getText();
    }

    public JTextField getTfPrimeCost() {
        return tfPrimeCost;
    }

    public void setTextPrimeCost(double sum){

        getTfPrimeCost().setText(String.valueOf(sum));
    }

    public JFormattedTextField getTfQuant() {
        return tfQuant;
    }

    public String getIngridientsQuant(){
        return getTfQuant().getText();
    }

    public JPanel getAnpPanel() {
        return anpPanel;
    }
}
