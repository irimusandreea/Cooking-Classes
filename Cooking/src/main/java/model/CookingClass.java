package model;

public class CookingClass implements Identifiable<Integer> {

    private int id;
    private String name;
    private String type;
    private String price;
    private String date;

    public CookingClass(String name, String type, String price, String date) {

        this.name = name;
        this.type = type;
        this.price = price;
        this.date = date;

    }

    public CookingClass(int id, String name, String type, String price, String date) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.date = date;

    }

    public CookingClass() {

        this.id = 0;
        this.name = "";
        this.type = "";
        this.price = "";
        this.date = "";

    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof CookingClass) {
            CookingClass c = (CookingClass) ob;
            if (c.name.equals(name) && c.type.equals(type) && c.price.equals(price) && c.date.equals(date))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return  id + " | "  + name + " | " + type + " | " + price + " lei "+ " | " + date;
    }

}
