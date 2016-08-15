package src.main.java.product;

/**
 * Created by prulov on 02.07.2016.
 */
public enum Types {

    BAND(0), CHAPLET(1), EARRINGS(2), PENDANT(3);

    private int indx;

    private Types(int indx) {
        this.indx = indx;
    }

    public int getIndx() {
        return indx;
    }
}
