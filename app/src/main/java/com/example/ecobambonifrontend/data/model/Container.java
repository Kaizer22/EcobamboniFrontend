package com.example.ecobambonifrontend.data.model;

public class Container {
    int ID;
    String location;
    String address;
    int fullness;
    String owner;
    int icon;

    public Container(int ID, String location, int isFull, int icon){
        this.ID = ID;
        this.location = location;
        this.fullness = isFull;
        this.icon = icon;
    }

    public Container(int ID, String location, String address,  int fullness, String owner){
        this.ID = ID;
        this.location = location;
        this.fullness = fullness;

        this.address = address;
        this.owner = owner;
    }

    public Container() {

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullness(int full) {
        fullness = full;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public int getIsFull(){
        return fullness;
    }
}
