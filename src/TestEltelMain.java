import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class TestEltelMain {

	private JFrame windowFrame = PanelUtills.globalFrame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestEltelMain window = new TestEltelMain();
					window.windowFrame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Application Exception Please go to unit support:" + e);
				}
			}
		});
	}

	public TestEltelMain() throws Exception {
		buildWindow();
	}


	
	private void buildWindow() throws Exception {

		BoardPanel board = new BoardPanel();
		
		WindowBuilderUtil.createShapesBasedOnJsonFile();
		
		WindowBuilderUtil.buildBasicFrame(windowFrame);
		
		board.createBoardPanel();

		board.addShapeIntoABoard(PanelUtills.shapeList);

		windowFrame.getContentPane().add(board);
	
		WindowBuilderUtil.addCheckBox(windowFrame);

		WindowBuilderUtil.addButtonOnFrame(windowFrame);

		
	}
	

	
	

	

	

}
