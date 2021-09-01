import java.awt.*;
import java.util.*;
public class UnitCell {
	public Shape shape;
	public Color color;
	public static final Color DEFAULT_COLOR = Color.WHITE;
	public static final Color FILLED_COLOR = Color.BLACK;
	
	public UnitCell(Shape shape, Color color){
		this.shape = shape;
		this.color = color;
	}
	public Shape getShape(){
		return shape;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getRandomColor(){
		Random l = new Random();
		return new Color(l.nextInt(255),l.nextInt(255),l.nextInt(255));
	}
	
	public boolean isFilled(){
		if(color != DEFAULT_COLOR){
			return true;
		} else {
			return false;
		}
	}
}
