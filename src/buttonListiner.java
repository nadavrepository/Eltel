import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

public class buttonListiner implements ActionListener {

	
	Timer timer = new Timer();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton butoonObject = (JButton)e.getSource();
		if("Start".equals(butoonObject.getText()))
		{
			timer = new Timer();
			PanelUtills.numberOfLines=PanelUtills.showMessageInputNumberOfLines();
			
			shapeMoverControler(timer);
			
			
		} else  if("Stop".equals(butoonObject.getText()))
				{
					timer.cancel();
					PanelUtills.createFileWithLocations();
				}
			
	
		
	}

	private void shapeMoverControler(Timer timer) {
		timer.schedule(new TimerTask() {
			public void run()
			{
				Random rand = new Random(); 
		    	
				for(ShapeAbstract item : PanelUtills.shapeList){
					if(item.getIsShapeEnable()) {
						
						int moveRand = rand.nextInt(4);
						
						switch(moveRand) {
						case 0:
							item.moveUp();
							
							
						break;
						case 1:
							item.moveDown();
						break;
					
						case 2:
							item.moveLeft();
						break;
						
						case 3:
							item.moveRight();
						break;
						}
						
						
						PanelUtills.globalFrame.repaint();
					}
				}
				
				
			}
		}, 0, 500);
	}

}
