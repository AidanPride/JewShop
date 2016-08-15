package src.main.java.guis;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prulov on 03.07.2016.
 */
public class BuyerComboBoxModel<Buyer> extends AbstractListModel implements ComboBoxModel {

    List<Buyer> data = new ArrayList<>();
    Buyer selection = null;

    public BuyerComboBoxModel(List<Buyer> data) {
        this.data = data;
    }

    public Object getElementAt(int index) {
        return data.get(index);
    }

    public int getSize() {
        return data.size();
    }

    public void setSelectedItem(Object anItem) {
        selection = (Buyer) anItem;
    }

    public Object getSelectedItem() {
        return selection;
    }
}
