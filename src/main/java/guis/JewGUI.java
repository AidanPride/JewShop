package src.main.java.guis;

import src.main.java.guis.tables.TableBuyers;
import src.main.java.guis.tables.TablePriceList;
import src.main.java.service.Service;
import src.main.java.shop.ShopStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by prulov on 03.07.2016.
 */
public class JewGUI {

    private ShopStore shopStore;
    private Service serv;

    private HeadPieceUI hP;
    private AddNewProductPanelUI anpUI;
    private SalePanelUI spUI;
    private SetNewQuantityPanel snqUI;

    private TablePriceList tPL;
    private TableBuyers tB;

    private JFrame frame;
    private JPanel panel;

    public JewGUI(ShopStore shopStore) {

        this.shopStore = shopStore;
        this.serv = new Service(shopStore);
        this.spUI = new SalePanelUI(shopStore, serv);
        this.anpUI = new AddNewProductPanelUI(shopStore, serv);
        this.hP = new HeadPieceUI(serv);
        this.snqUI = new SetNewQuantityPanel(shopStore, serv);

        this.tPL = new TablePriceList(shopStore);
        this.tB = new TableBuyers(shopStore);

        frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("МАГАЗИН БИЖУТЕРИИ \"НАТАЛИ\"");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1365, 725));
        frame.setLocation(0, 0);

        // adding HeadPieceUI
        panel = hP.createHeadPieceUI();
        frame.getContentPane().add(panel);

        initMenuBar();
        frame.pack();
        frame.setVisible(true);
    }

    private void initMenuBar() {

        Font bigFont = new Font("Verdana", Font.BOLD, 21);
        Font font = new Font("Verdana", Font.BOLD, 18);
        Font fant = new Font("Verdana", Font.BOLD, 15);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setFont(bigFont);
        menuBar.add(fileMenu);



        // tables
        JMenu tables = new JMenu("ТАБЛИЦЫ БАЗЫ ДАННЫХ");
        tables.setFont(font);
        fileMenu.add(tables);
        fileMenu.addSeparator();

        JMenuItem priceList = new JMenuItem("Прайс-лист");
        priceList.setFont(fant);
        priceList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        tables.add(priceList);
        tables.addSeparator();

        priceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                priceListShow();
            }
        });

        JMenuItem buyersList = new JMenuItem("Клиентская база");
        buyersList.setFont(fant);
        buyersList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        tables.add(buyersList);
        tables.addSeparator();

        buyersList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buyersListShow();
            }
        });



        // others
        JMenu buyMenu = new JMenu("ПРОВЕСТИ ПРОДАЖУ");
        buyMenu.setFont(font);
        fileMenu.add(buyMenu);
        fileMenu.addSeparator();

        buyMenu.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                showSalePanelUI();
            }
        });

        JMenu addNewProd = new JMenu("ДОБАВИТЬ НОВЫЙ ПРОДУКТ В БАЗУ");
        addNewProd.setFont(font);
        fileMenu.add(addNewProd);
        fileMenu.addSeparator();

        addNewProd.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                showAddNewProductUI();

            }
        });

        JMenu addNewQuant = new JMenu("УСТАНОВИТЬ НОВОЕ КОЛ-ВО ТОВАРА");
        addNewQuant.setFont(font);
        fileMenu.add(addNewQuant);
        fileMenu.addSeparator();

        addNewQuant.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                showSetNewQuantityUI();

            }
        });

        JMenuItem exitItem = new JMenuItem("ВЫХОД");
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        frame.setJMenuBar(menuBar);
    }

    private void showSalePanelUI(){
        getFrame().getContentPane().removeAll();
        JPanel panel = spUI.createSalePanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showAddNewProductUI(){
        getFrame().getContentPane().removeAll();
        JPanel panel = anpUI.getAnpPanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }

    private void showSetNewQuantityUI(){
        getFrame().getContentPane().removeAll();
        JPanel panel = snqUI.getNqPanel();
        getFrame().getContentPane().add(panel);
        getFrame().pack();
        getFrame().repaint();
    }


    // tables

    public void priceListShow(){
        getFrame().getContentPane().removeAll();
        JTable table = tPL.createPriceListTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public void buyersListShow(){
        getFrame().getContentPane().removeAll();
        JTable table = tB.createBuyerTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        getFrame().getContentPane().add(scrollPane);
        getFrame().pack();
        getFrame().repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}
