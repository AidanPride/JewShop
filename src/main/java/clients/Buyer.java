package clients;


import java.io.Serializable;

public class Buyer implements Serializable{

    private String name;

    public Buyer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
