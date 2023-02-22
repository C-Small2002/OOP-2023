package ie.tudublin;

import processing.data.Table;
import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.TableRow;



public class Star extends PApplet{

    private boolean hab;
	private String displayName;
	private float distance;
	private float xG;
	private float yG;
	private float zG;
	private float absMag;

    public Star(TableRow tr)
 	{
 		this(
 			tr.getInt("Hab?") == 1, 
 			tr.getString("Display Name"), 
 			tr.getFloat("Distance"),
 			tr.getFloat("Xg"),
 			tr.getFloat("Yg"),
 			tr.getFloat("Zg"),
 			tr.getFloat("AbsMag")
 		);
 	}
 	
 	public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) {
 		this.hab = hab;
 		this.displayName = displayName;
 		this.distance = distance;
 		this.xG = xG;
 		this.yG = yG;
 		this.zG = zG;
 		this.absMag = absMag;
 	}

    @Override	
    public String toString() {
        return "Star [absMag = " + absMag + ", displayName = " + displayName + ", distance = " + distance + ", hab = " + hab + ", xG = " + xG + ", yG = " + yG + ", zG = " + zG + "]";
    }
    
}
