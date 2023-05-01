package ie.tudublin;

import processing.data.TableRow;

public class Product {
    String name;
    float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

    public Product(TableRow tr){
        this(tr.getString("Name"), tr.getFloat("Price"));
    }

    public String toString(){
        return "Product [ Name: " + name + " Price: " + price + " ]";
    }
}
