import java.awt.Graphics;
import java.awt.Graphics2D;


public class TriangleShape extends ShapeAbstract {
	
	
		public void buildTriangle(Graphics graphicDraw) {
			
			int x = this.getX();
			int y = this.getY();
			
			
			Graphics2D graphicDraw2d = (Graphics2D) graphicDraw;
		    
			graphicDraw2d.setColor(getColorFromName());
		    int leftX = this.getWidth();
		    int rightX = this.getWidth() * 2;
		    int heighY = -this.getHeigh();
		    if(this.getIsShapeEnable()) 
		    {
		    	
		    	graphicDraw2d.fillPolygon(new int[]{x, x + leftX, x + rightX}, new int[]{y, y + heighY, y }, 3);
		    
		    }
		    else 
		    	graphicDraw2d.fillRect(this.getX(), this.getY(), 0, 0);  
		}
		
		
		
		
		public TriangleShape(int id, String name, String shape, String color, String size, int x, int y) throws IllegalAccessException {
			super(id, name, shape, color, size, x, y);
		}
		
		
		
}
