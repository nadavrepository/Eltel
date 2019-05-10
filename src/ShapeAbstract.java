import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public abstract class ShapeAbstract {
	private boolean shapeEnable;
	private int entityID;
	private String name;
	private String shape;
	private String color;
	private String size;
	private int origX;
	private int origY;
	private int x;
	private int y;
	private int height;
	private int width;
	private List<String> stepsList;
	private int moveInterval = 1;

	
	public ShapeAbstract(int id, String name, String shape, String color, String size, int x, int y) throws IllegalAccessException {
		this.shapeEnable = false;
		this.stepsList = new ArrayList<String>();
		this.entityID = id;
		this.name = name;
		this.shape = shape;
		this.color = color;
		this.size = size;
		updateShapeSize(size);
		this.x =x;
		this.y =100 - y;
		origX=x;
		origY=this.y;
		
	}
	
	

	public int getEntityID() {
		return this.entityID;
	}
	
	public String getSize() {
		return this.size;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean getIsShapeEnable() {
		return this.shapeEnable;
	}
	
	public void setIsShapeEnable(boolean shapeEnable) {
		 this.shapeEnable=shapeEnable;
	}
	
	public int getHeigh() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public String getName() {
		return this.name;
	}
	public String getShape() {
		return this.shape;
	}
	public String getColor() {
		return this.color;
	}
	
	public List<String> getListByPlayInput() {
		return stepsList;
	}
	

	public void addStep() {
		if(stepsList.size()<PanelUtills.numberOfLines)
		{
		this.stepsList.add(this.getCoordinates());
		}
	}
	

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	

	
	
	public void moveUp() {
		int validateYLocation= y-height-moveInterval;
		
		if(validateYLocation>=0 && !(x==origX && (moveInterval+y)==origY) )
		{
			y -=moveInterval;
		} else y += moveInterval;
		addStep();
			
	}
	
	public void moveDown() {
		int validateYLocation=y+moveInterval;
		
		if(validateYLocation<=100 && !(x==origX && (y+moveInterval)==origY) )
		{
			y += moveInterval;
		} else y -=moveInterval;

		addStep();
	
		
	}
	
	public void moveLeft() {
		int newXLocation= x-moveInterval;
		
		if(newXLocation>0 && !(newXLocation==origX && y==origY) )
		{
			x-=moveInterval;
		} else x+=moveInterval;
		addStep();
	}
	
	public void moveRight() {

		int validateXLocation= x+moveInterval+width;
		
		if(validateXLocation<=100 && !((x+moveInterval)==origX && y==origY) )
		{
			x+=moveInterval;
		} else x-=moveInterval;
		addStep();

		
		
	}
	
	


	private void setHeight(int height) {
		this.height = height;
	}


	private void setWidth(int width) {
		this.width = width;
	}

	
	public String getCoordinates() {
		return x + "," + (100-y);
	}
	
	
	
	protected Color getColorFromName() {
		switch (this.color) {
		case "green":
			return Color.GREEN;
		case "red":
			return Color.RED;
		case "blue":
			return Color.BLUE;
		default:
		
		}
		return null;
	}



	
	private void updateShapeSize(String size) throws IllegalAccessException {
		if("small".equals(size)) {
			setHeight(4); 
			setWidth(4);
			
		}
		else if("medium".equals(size)) {
			setHeight(8); 
			setWidth(8);
		}
		else if ("large".equals(size)) {
			setHeight(12); 
			setWidth(12);
		} else   
		{
			setHeight(12); 
			setWidth(12);
		}
		
		
	}

	
	
	
}
