package src.main.java.guis;

import src.main.java.controllers.SetNewQuantity;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.NumberFormat;

/**
 * Created by prulov on 18.07.2016.
 */
public class SetNewQuantityPanel {

    private ShopStore shopStore;
    private Service serv;
    private JPanel nqPanel;

    private JTextField prodArticul;
    private JFormattedTextField neoQuant;

    public SetNewQuantityPanel(ShopStore shopStore, Service serv){
        this.shopStore = shopStore;
        this.serv = serv;
        this.nqPanel = createNewQuantPanel();
    }

    private JPanel createNewQuantPanel() {

        nqPanel = new JPanel();
        nqPanel.setLayout(new GridBagLayout());
        nqPanel.setBackground(Color.CYAN);

        Border matte = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLUE);
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border titled = BorderFactory.createTitledBorder(matte, "SET NEW QUANTITY OF THE PRODUCT", TitledBorder.CENTER,
                TitledBorder.CENTER, new Font("Garamond", Font.BOLD, 24), Color.BLUE);
        nqPanel.setBorder(titled);

        NumberFormat nf = NumberFormat.getInstance();

        JLabel set = new JLabel("Select product's articul");
        set.setFont(new Font("Garamond", Font.BOLD, 20));
        set.setForeground(Color.BLUE);
        nqPanel.add(set, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel first = new JLabel("Product's articul");
        first.setFont(new Font("Garamond", Font.ITALIC, 20));
        first.setForeground(Color.BLUE);
        nqPanel.add(first, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        prodArticul = new JTextField();
        prodArticul.setFont(new Font("Garamond", Font.BOLD, 20));
        prodArticul.setForeground(Color.BLUE);
        prodArticul.setHorizontalAlignment(JTextField.RIGHT);
        prodArticul.setColumns(12);
        nqPanel.add(prodArticul, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JLabel second = new JLabel("New quantity of the Product");
        second.setFont(new Font("Garamond", Font.ITALIC, 20));
        second.setForeground(Color.BLUE);
        nqPanel.add(second, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        neoQuant = new JFormattedTextField(nf);;
        neoQuant.setFont(new Font("Garamond", Font.BOLD, 20));
        neoQuant.setForeground(Color.BLUE);
        neoQuant.setHorizontalAlignment(JTextField.RIGHT);
        neoQuant.setColumns(12);
        neoQuant.setValue(0);
        nqPanel.add(neoQuant, new GridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));

        JButton changer = new JButton("Set new quantity");
        changer.setFont(new Font("Garamond", Font.BOLD, 20));
        nqPanel.add(changer, new GridBagConstraints(1, 3, 3, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
        changer.setBorder(empty);
        changer.setForeground(Color.BLUE);
        changer.addActionListener(new SetNewQuantity(shopStore, serv, this));

        return nqPanel;
    }

    public JTextField getProdArticul() {
        return prodArticul;
    }

    public String getArticul(){
        return getProdArticul().getText();
    }

    public JFormattedTextField getNeoQuant() {
        return neoQuant;
    }

    public int getNewQuantity(){
        return Integer.parseInt(getNeoQuant().getText());
    }

    public JPanel getNqPanel() {
        return nqPanel;
    }
}
