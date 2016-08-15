package src.main.java.clients;

import java.io.Serializable;

/**
 * Created by prulov on 19.07.2016.
 */
public class Manager implements Serializable {

    private long id;
    private String surName;
    private String name;

    public Manager(){}

    public Manager(long id, String surName, String name){
        this.id = id;
        this.surName = surName;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){

        return "ID_" + getId() + ", " + getName() + " " + getSurName();
    }

    @Override
    public boolean equals(Object obj){

        if (obj instanceof Manager){
            Manager manager = (Manager) obj;
            if (this.surName != null && this.name != null && this.id == ((Manager) obj).getId() &&
                    this.getSurName().equals(((Manager) obj).getSurName()) && this.getName().equals(((Manager) obj).getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){

        Manager manager = new Manager();
        int result = 2;
        result *= 37 + name.hashCode();
        result *= 37 + ((Long) id).hashCode();
        if(surName != null){result *= 37 + surName.hashCode();}
        if(name != null){result *= 37 + name.hashCode();}

        return result;
    }
}
