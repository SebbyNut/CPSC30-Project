import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.Map;


public class SecondGUI {
	//This GUI holds the table to help the user pick the right book
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();

	public SecondGUI() throws FileNotFoundException {
		//Creates the frame
		frame.setBounds(1000, 10, 315, 340);
		frame.add(panel);
		
		//The panel
		panel.setLayout(null);

		//A label to put on top of the table
		JLabel key = new JLabel("THE KEY: ");
		key.setBounds(0, 0, 315, 20);
		key.setFont(new Font("Serif", Font.BOLD, 16));
		key.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(key);

		//HTML used for GUI
		String printCourses = "<html>";
		for (Map.Entry<String, String> set : Student.dict.entrySet()) {
			//Uses the HashMap from the Student class to create the table
		    printCourses = printCourses + set.getKey() + " = " + set.getValue() + "<br>";
		}
		printCourses = printCourses + "<html>";

		//Create the table
		JLabel lbel = new JLabel();
		lbel.setText(printCourses);
		lbel.setVerticalAlignment(SwingConstants.NORTH);
		lbel.setBounds(0, 20, 310, 420);
		panel.add(lbel);

		frame.setVisible(true);
	}
}