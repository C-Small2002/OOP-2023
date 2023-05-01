package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import java.util.ArrayList;


public class CafeRubis extends PApplet {


    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Product> bill = new ArrayList<Product>();
    float border = 30f;

    public void settings()
	{
		size(800, 800);
	}

    public void setup(){
        loadData();
    }

    public void loadData(){
        Table t = loadTable("cafe.csv", "header");
        for(TableRow row : t.rows()){
            Product p = new Product(row);
            products.add(p);
        }
    }

    public void printData(){
        for(Product p : products){
            System.out.println(p);
        }
    }

    public void displayProducts(){
        stroke(0,0,0);
        line(width/2, height/6-border, width/2, height - border - border);
        for(int i = 0; i<products.size(); i++){
            float y = PApplet.map(i,0,products.size(),50,height-border);
            fill(255);
            rect(border, y, 300, 750);
            fill(0);
            textSize(20);
            text(products.get(i).getName(),border+border, y+border+border);
            text(products.get(i).getPrice(), border + border + border + border+border+70, y + border+border);
        }
    }

    public void displayBill(){
        
    }

    public void draw(){
        background(150,150,150);
        displayProducts();
    }
    
}
