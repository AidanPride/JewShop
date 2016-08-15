package src.main.java.clients;


import java.io.Serializable;

public class Buyer implements Serializable{

    private long id;
    private String name;
    private Region region;
    private WaysOfSells waysOfSells;
    private Manager manager;

    public Buyer(long id, String name, Region region, WaysOfSells waysOfSells, Manager manager) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.waysOfSells = waysOfSells;
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public WaysOfSells getWaysOfSells() {
        return waysOfSells;
    }

    public void setWaysOfSells(WaysOfSells waysOfSells) {
        this.waysOfSells = waysOfSells;
    }

    @Override
    public String toString() {
        return getName() + ", " + getRegion() + ", " + getId();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Buyer){
            Buyer buyer = (Buyer) obj;
            return (id > 0 && id == buyer.getId() && name != null && name.equals(buyer.getName()) &&
                    region.equals(buyer.getRegion()) && waysOfSells.equals(buyer.getWaysOfSells()) &&
                    manager.equals(buyer.getManager()));
        }
        return false;
    }
}
