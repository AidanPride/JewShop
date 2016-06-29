package clients;


import employers.Manager;

import java.io.Serializable;

public class Buyer implements Serializable{

    private String name;
    private Region region;
    private WaysOfSells waysOfSells;
    private Manager manager;

    public Buyer() {
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
}
