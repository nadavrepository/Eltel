import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import org.json.simple.JSONObject;

public class WindowBuilderUtil {

	public static void buildBasicFrame(JFrame frame) {
		frame.setBounds(500, 100, 350, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		
	}

	
	public static void createShapesBasedOnJsonFile() throws Exception {
		int MaxShapes=0;
        for (Object listJSON : PanelUtills.getJSONAraay()) {
        	if(MaxShapes == 10) {
        		break;
        	}
            ShapeAbstract shape = createShapeBasedOnShapeType(listJSON);
            PanelUtills.shapeList.add(shape);
            MaxShapes++;
        }
        
		
	} 
	
	
	
	private static ShapeAbstract createShapeBasedOnShapeType(Object jsonInput) throws IllegalAccessException {
		if (jsonInput != null) {
			JSONObject person = (JSONObject) jsonInput;

			String x = (String) person.get("X");
            
            String y = (String) person.get("Y");
            
            String id = (String) person.get("entity_ID");

            String shape = (String) person.get("shape");
            
            
            
            if(shape.toUpperCase().equals(Shape.CIRCLE.toString())){
            	
            	return new CircleShape(Integer.parseInt(id), (String) person.get("name"), (String) person.get("shape"), (String) person.get("color"), (String) person.get("size"), Integer.parseInt(x), Integer.parseInt(y) );
            } 
            else if (shape.toUpperCase().equals(Shape.TRIANGLE.toString())) {
            	
            	return new TriangleShape(Integer.parseInt(id), (String) person.get("name"), (String) person.get("shape"), (String) person.get("color"), (String) person.get("size"), Integer.parseInt(x), Integer.parseInt(y) );
            }
            else if (shape.toUpperCase().equals(Shape.SQUARE.toString())) {
            	return new SquareShape(Integer.parseInt(id), (String) person.get("name"), (String) person.get("shape"), (String) person.get("color"), (String) person.get("size"), Integer.parseInt(x), Integer.parseInt(y) );
            }
		}
		return null;
		
	}


	public static void addButtonOnFrame(JFrame windowFrame) {
		
		ActionListener buttonListinet = new buttonListiner();
		
		
        JButton btnStart = new JButton("Start");
        
        btnStart.addActionListener(buttonListinet);
        
		
		btnStart.setBounds(12, PanelUtills.getNewButtonLocation(), 83, 24);
		windowFrame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		
		btnStop.addActionListener(buttonListinet );
		
		btnStop.setBounds(12, PanelUtills.getNewButtonLocation(), 83, 24);
		windowFrame.getContentPane().add(btnStop);

		
		
		
	}


	public static void addCheckBox(JFrame windowFrame) {
		int numberOfCheckBox=0;
		for (ShapeAbstract shape : PanelUtills.shapeList) 
		{
			
			String name = "eID" + shape.getEntityID() +"_" + shape.getName();
			
			JCheckBox checkBox = new JCheckBox(name);
			checkBox.setName(name);
			Map<String,Integer> checkBoxLocation = new HashMap<String,Integer>();
			checkBoxLocation.put(name,numberOfCheckBox);
			
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				checkBoxLocation.get(checkBox.getName());	
					
					  ShapeAbstract shapeItem =	PanelUtills.shapeList.get(checkBoxLocation.get(checkBox.getName()));
					  if(shapeItem != null) 
					  {
						  shapeItem.setIsShapeEnable(!shapeItem.getIsShapeEnable());
						  windowFrame.repaint();
						  
					  }
					
				}
			});
			checkBox.setBounds(8, PanelUtills.getNewButtonLocation(), 130, 23);
			windowFrame.getContentPane().add(checkBox);
			numberOfCheckBox+=1;
		}		
	}

	
	
	
}
