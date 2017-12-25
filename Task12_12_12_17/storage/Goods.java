package com.company.Task12_12_12_17.storage;

public class Goods {

    private int id;
    private String name;
    private int sectionID;

    public Goods(int id, String name, int sectionID) {
        this.id = id;
        this.name = name;
        this.sectionID = sectionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setDepartmentID(int sectionID) {
        this.sectionID = sectionID;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentID=" + sectionID +
                '}';
    }
}
