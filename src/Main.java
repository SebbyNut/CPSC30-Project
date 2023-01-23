import java.io.FileNotFoundException;
import java.util.Queue;

public class Main {
	
	public static StudentQueue newStudentQueue;
	public static int points;
	
	public static void main (String args[]) throws FileNotFoundException {		
		//Keeps track of the points
		points = 0;
		
		//Generates a queue of students
		Queue newQueue = StudentQueue.generateQueue();
		newStudentQueue = new StudentQueue(newQueue);
		
		//Main GUI
		new GUI();

		//GUI with table
		new SecondGUI();
	}

}