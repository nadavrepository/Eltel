import java.awt.Graphics;
import java.awt.Graphics2D;


public class SquareShape extends ShapeAbstract{

	public void buildSquare(Graphics graphicDraw) 
	{
		Graphics2D graphicDraw2d = (Graphics2D) graphicDraw;
        graphicDraw2d.setColor(getColorFromName());
        if(this.getIsShapeEnable())
        {
        	graphicDraw2d.fillRect(this.getX(), this.getY(), this.getHeigh(), this.getWidth());
        }
         else 
        	graphicDraw2d.fillRect(this.getX(), this.getY(), 0, 0);  
	}
	
	public void hide(Graphics graphicDraw) 
	{
		Graphics2D graphicDraw2d = (Graphics2D) graphicDraw;
		graphicDraw2d.fillRect(this.getX(), this.getY(), 0, 0);  
		graphicDraw2d.setColor(getColorFromName());
        
	}
	
	
	
	public SquareShape(int id, String name, String shape, String color, String size, int x, int y) throws IllegalAccessException {
		super(id, name, shape, color, size, x, y);	
	}
	
}
