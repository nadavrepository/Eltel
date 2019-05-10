import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class PanelUtills {

	public static int locationIndex=20;
	public static List<ShapeAbstract> shapeList = new ArrayList<>();
	public static JFrame globalFrame =  new JFrame();
	public static int numberOfLines =0;
	
	
	
	public static int getNewButtonLocation() {
					
		return locationIndex+=30;
	}
	

	
	
	public static JSONArray	getJSONAraay() throws Exception {
	
	JSONParser parser = new JSONParser();
   
	return (JSONArray) parser.parse(new FileReader("entityData.json"));	

	}

 	
 	
	
	
	
	public static int showMessageInputNumberOfLines(){
 		
		String inputNumberInString = JOptionPane.showInputDialog(null,
		        "Please Enter number of locations?", "Enter", JOptionPane.PLAIN_MESSAGE);
				if(inputNumberInString != null) {
					try {
						return Integer.parseInt(inputNumberInString);
					}
					catch (NumberFormatException ex) {
						 new Exception(ex);
						
					}
				}
				return 0;
		
 		
 	}
		

	public static void createFileWithLocations() 
	{
		
		try (PrintWriter openWriter = new PrintWriter(new File("locations.csv"))) 
		{
			StringBuilder Line = new StringBuilder();
		      Line.append("ID,");
		      
		      Line.append("Name,");
		      
		      Line.append("Location");
		      
		      Line.append('\n');
		      
		      
			for (ShapeAbstract shape : PanelUtills.shapeList) {
				if( shape != null && shape.getIsShapeEnable()) {
					List <String> pos = shape.getListByPlayInput();
					for(String loc : pos) {
						if(loc != null) {
							Line.append("e" + shape.getEntityID());
							Line.append(',');
							Line.append(shape.getName());
							Line.append(',');
							Line.append(loc);
							Line.append('\n');
						}
					}
					
				}
			}
		    
			openWriter.write(Line.toString());

		    } catch (FileNotFoundException e) {
		    System.out.println("Can't create a file");
		    }
		
	}





 	
 	
 	
 	
	
	
	
}
