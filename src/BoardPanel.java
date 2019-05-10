import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BoardPanel extends JPanel { 

	private List<ShapeAbstract> shapesList = new ArrayList<>();;
	
	public void createBoardPanel()
	{
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.GRAY);
		setBounds(165, 60, 100, 100);

	}
	
	public void addShapeIntoABoard(List<ShapeAbstract> shapes) {

	
        for(ShapeAbstract item : shapes){
        	
        	String shape = item.getShape().toUpperCase();
        	
        	if(shape.equals(Shape.CIRCLE.toString())) {
        		addCircleAndBuild((CircleShape) item);
        	} else if (shape.equals(Shape.TRIANGLE.toString())) {
        		addTriangleAndBuild((TriangleShape)item);
        	}else if (shape.equals(Shape.SQUARE.toString())) 
        	{
        		addSquareAndBuild((SquareShape)item);
        	}
    	}
     }
	
    public void addTriangleAndBuild(TriangleShape t) {
    	shapesList.add(t);
        repaint();
    }
	
	public void addCircleAndBuild(CircleShape c) {
		shapesList.add(c);
        repaint();
    }

    public void addSquareAndBuild(SquareShape s) {
    	shapesList.add(s);
        repaint();
    }
    

	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapesList) {
            if (s instanceof CircleShape) {
                ((CircleShape) s).buildCircle(g);
            } else if (s instanceof TriangleShape) {
                ((TriangleShape) s).buildTriangle(g);
            } else {
            	((SquareShape) s).buildSquare(g);            
            }
        }
    }
	
	
	
	
}
