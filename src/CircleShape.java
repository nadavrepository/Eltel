import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class CircleShape extends ShapeAbstract{

	
	public void buildCircle(Graphics graphicDraw) 
	{
        Graphics2D graphicDraw2d = (Graphics2D) graphicDraw;
        
        Ellipse2D.Double drawCircle = new Ellipse2D.Double(this.getX() , this.getY(), this.getHeigh(), this.getWidth());
	    
        graphicDraw2d.setColor(getColorFromName());
        
	    if(this.getIsShapeEnable())	
	    { 
	    	graphicDraw2d.fill(drawCircle);
	    }
	    
	    else 
	    	graphicDraw2d.fillOval(this.getX(), this.getY(), 0, 0);  
    }
	
	
	public CircleShape(int entityID, String name, String shape, String color, String size, int x, int y) throws IllegalAccessException {
		super(entityID, name, shape, color, size, x, y);
	}
}
