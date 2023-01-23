import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class StudentQueue {
	
	//Creating a queue using the students generated from the Student class
	public static Queue<Student> queue = new LinkedList<>();
	public static String theQueue;

	Queue studentLine;
	public StudentQueue(Queue line) {
		//Constructor
		studentLine = line;
	}

	
	public static Queue generateQueue() throws FileNotFoundException {
		//generates the queue
		int counter = 0;
		while(counter  < 10) {
			//generates 10 students for the queue
			Student current = Student.generateStudent();
			queue.add(current);
			counter++;
		}		
		return queue;
	}
	
	public String printQueue() {
		//prints the queue using HTML for the GUI 
		theQueue = "";
		int extra = 0;
		for(Student a:queue) {
			if (extra == 0){
				 theQueue = "<br><br>" + a.studentName + ": " + a.studentGrade;
				 extra++;
			}
			else if (extra < 9){
				theQueue = "<br><br>" + a.studentName + ": " + a.studentGrade + theQueue;
				extra++;
			}
			else {
				theQueue = a.studentName + ": " + a.studentGrade + theQueue;
			}
		}
		theQueue = "<html>" + theQueue + "<html>";
		//System.out.println(theQueue);
		return theQueue;
	}
	
	public Student addStudent() throws FileNotFoundException {
		//Pops the head of the queue out, while simultaneously pushing a new one in
		Student newStudent = Student.generateStudent();
		queue.add(newStudent);
		Student removed = queue.remove();
		return removed;
	}

}