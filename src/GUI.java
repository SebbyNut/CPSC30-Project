import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.util.Timer;
import java.util.TimerTask;

public class GUI implements ActionListener{
	private static JLabel label;
	private static JLabel studentNandG;
	private static JLabel studentC;
	private static JPanel panel = new JPanel();
	private static JFrame frame = new JFrame();
	private static JLabel thePoints;
	private static Student currentStudent;
	private static JButton S10;
	private static JButton SS10;
	private static JButton M10;
	private static JButton bio20;
	private static JButton Phy20;
	private static JButton ELA10;
	private static JButton Chem20;
	private static JButton ELA20;
	private static JButton SS20;
	private static JButton M20;
	private static JButton bio30;
	private static JButton ELA30;
	private static JButton SS30;
	private static JButton M30;
	private static JButton M31;
	private static int studentsHelped = 0;
	
	public void showCurrentStudent(Student currentStudent) {
		//Shows the current student who we are trying to serve, with their name, grade and courses
		studentNandG.setText(currentStudent.studentName + ": Grade " + currentStudent.studentGrade);
		String currentCourses = "";
		int first = 0;
		for(String x:currentStudent.studentCourses) {
			if (first != 3) {
				currentCourses = "<br>" + x + currentCourses;				
				first++;
			}
			else {
			currentCourses = x + currentCourses;
			}
		}
		//Again HTML is used
		currentCourses = "<html>" + currentCourses + "<html>";
		studentC.setText(currentCourses);
	}

	public GUI() throws FileNotFoundException {
		//Creates the frame
		frame.setSize(1000, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		//Creates the panel
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		//Creates the scoreboard
		thePoints = new JLabel("Points: " + Main.points);
		thePoints.setBounds(0, 635, 150, 55);
		thePoints.setFont(new Font ("Calibri", Font.BOLD, 20));
		thePoints.setForeground(Color.white);
		thePoints.setBackground(Color.GRAY);
		thePoints.setOpaque(true);
		thePoints.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(thePoints);

		//Creates the area for current student's name and grade
		studentNandG = new JLabel();
		studentNandG.setBounds(150, 160, 500, 100);
		studentNandG.setFont(new Font ("Calibri", Font.BOLD, 25));
		studentNandG.setBackground(Color.GRAY);
		studentNandG.setForeground(Color.white);
		studentNandG.setOpaque(true);
		studentNandG.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(studentNandG);
		
		//Creates the area for the current student's courses
		studentC = new JLabel();
		studentC.setBounds(800, 160, 200 , 100);
		studentC.setFont(new Font ("Calibri", Font.PLAIN, 16));
		studentC.setBackground(Color.black);
		studentC.setForeground(Color.white);
		studentC.setOpaque(true);
		panel.add(studentC);
		
		//Creates a label to put in front of the courses
		JLabel courseLabel = new JLabel("Courses: ");
		courseLabel.setBounds(650, 160, 150, 100);
		courseLabel.setFont(new Font ("Calibri", Font.BOLD, 20));
		courseLabel.setBackground(Color.black);
		courseLabel.setForeground(Color.white);
		courseLabel.setOpaque(true);
		courseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(courseLabel);

		//Gets the current student out of the queue, and displays them with their information in the right spots
		currentStudent = Main.newStudentQueue.addStudent();
		showCurrentStudent(currentStudent);
		
		//Create the title
		JLabel title = new JLabel("Checkout System");
		title.setBounds(0, 0, 1000, 160);
		title.setFont(new Font ("Calibri", Font.BOLD, 40));
		title.setBackground(Color.DARK_GRAY);
		title.setForeground(Color.white);
		title.setOpaque(true);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(title);
		
		//Creates a label to put on top of the queue
		JLabel queueTitle = new JLabel("<html>Current Line<br>----------------<html>");
		queueTitle.setBounds(0, 160, 150, 75);
		queueTitle.setFont(new Font("Calibri", Font.BOLD, 22));
        queueTitle.setForeground(Color.white);
        queueTitle.setBackground(Color.black);
        queueTitle.setOpaque(true);
        queueTitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(queueTitle);
		
		//Creates the label for the queue
		label = new JLabel();
		label.setText(Main.newStudentQueue.printQueue());
		label.setBounds(0, 230, 150, 405);
        label.setFont(new Font("Calibri", Font.PLAIN, 16));
        label.setForeground(Color.white);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.NORTH);
		panel.add(label);

		//Gets the pictures of all 15 potential textbooks
		ImageIcon sci10Icon = new ImageIcon(".\\images\\Sci 10.png");
    	ImageIcon Math10Icon = new ImageIcon(".\\images\\Math10.jpg");
    	ImageIcon Social10Icon = new ImageIcon(".\\images\\Social10.png");
    	ImageIcon Bio20Icon = new ImageIcon(".\\images\\Bio20.png");
    	ImageIcon PhysIcon = new ImageIcon(".\\images\\Phyis20.png");
		ImageIcon LA10Icon = new ImageIcon(".\\images\\La10.png");
    	ImageIcon ChemIcon = new ImageIcon(".\\images\\ChemTB.png");
    	ImageIcon LA20Icon = new ImageIcon(".\\images\\La20.png");
    	ImageIcon Social20Icon = new ImageIcon(".\\images\\Social 20.png");
    	ImageIcon Math20Icon = new ImageIcon(".\\images\\Math 20.png");
    	ImageIcon Bio30Icon = new ImageIcon(".\\images\\Bio30.png");
    	ImageIcon LA30Icon = new ImageIcon(".\\images\\La12.png");
    	ImageIcon Social30Icon = new ImageIcon(".\\images\\Social 30.png");
    	ImageIcon Math30Icon = new ImageIcon(".\\images\\Math 30.png");
     	ImageIcon Math31Icon = new ImageIcon(".\\images\\Math 31.png");
		
		 //Next bit is just making course JButtons with the images above 
		S10=new JButton(sci10Icon);  
		S10.setBounds(214, 267, 100, 133);
		S10.addActionListener(this);  

		SS10=new JButton(Social10Icon);  
		SS10.setBounds(364, 267, 100, 133);  
		SS10.addActionListener(this);

		M10=new JButton(Math10Icon);   
		M10.setBounds(514, 267, 100, 133);
		M10.addActionListener(this); 

		bio20=new JButton(Bio20Icon); 
		bio20.setBounds(664, 267, 100, 133);
		bio20.addActionListener(this);

		Phy20=new JButton(PhysIcon);    
		Phy20.setBounds(814, 267, 100, 133);
		Phy20.addActionListener(this);

		ELA10=new JButton(LA10Icon);    
		ELA10.setBounds(214, 407, 100, 133);
		ELA10.addActionListener(this);

		Chem20=new JButton(ChemIcon);
		Chem20.setBounds(364, 407, 100, 133);
		Chem20.addActionListener(this);

		ELA20=new JButton(LA20Icon);  
		ELA20.setBounds(514, 407, 100, 133);
		ELA20.addActionListener(this);

		SS20=new JButton(Social20Icon);
		SS20.setBounds(664, 407, 100, 133);
		SS20.addActionListener(this);

		M20=new JButton(Math20Icon);
		M20.setBounds(814, 407, 100, 133);
		M20.addActionListener(this);

		bio30=new JButton(Bio30Icon);
		bio30.setBounds(214, 547, 100, 133);
		bio30.addActionListener(this);

		ELA30=new JButton(LA30Icon);
		ELA30.setBounds(364, 547, 100, 133);
		ELA30.addActionListener(this);

		SS30=new JButton(Social30Icon);
		SS30.setBounds(514, 547, 100, 133);
		SS30.addActionListener(this);

		M30=new JButton(Math30Icon);
		M30.setBounds(664, 547, 100, 133);
		M30.addActionListener(this);

		M31=new JButton(Math31Icon);
		M31.setBounds(814, 547, 100, 133);
		M31.addActionListener(this);
	 
	 
		 //Adds buttons
		 panel.add(S10);
		 panel.add(SS10);
		 panel.add(M10);
		 panel.add(bio20);
		 panel.add(Phy20);
		 panel.add(ELA10);
		 panel.add(Chem20);
		 panel.add(ELA20);
		 panel.add(SS20);
		 panel.add(M20);
		 panel.add(bio30);
		 panel.add(ELA30);
		 panel.add(SS30);
		 panel.add(M30);
		 panel.add(M31);

		frame.setVisible(true);
		
		//Opening message
		JLabel message = new JLabel("<html><center>Welcome to the Checkout System!<br>The rules "
		+ "are simple: Get each student their right books by clicking on the textbooks that match "
		+ "their courses.<br>10 points for a correct choice, -5 points for an incorrect choice<br> "
		+ "You have 90 seconds, Good Luck!<html>");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		JOptionPane.showMessageDialog(null, message, "Welcome", JOptionPane.DEFAULT_OPTION);
		

		//Creating the JLabel to hold the timer
		JLabel time = new JLabel();
		time.setBounds(880, 10, 80, 40);
		time.setForeground(Color.white);
		time.setBackground(Color.black);
		time.setOpaque(true);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(time);

		//Creating the timer
		Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
			//Should be 90
            int i = 90;

            public void run() {

                time.setText("Time left: " + i);
                i--;

                if (i < 0) {
					//Once timer ends, print the final score and ends the program
                    timer.cancel();
                    time.setText("Time Over");
					JLabel finalMessage = new JLabel("<html><center>Your final score was "+ Main.points + " points!"
					+ "<br>You helped " + studentsHelped + " students!<html>");
					if (Main.points == -45){
						finalMessage.setText("Hi Andy!");
					}
					finalMessage.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, finalMessage, "End", JOptionPane.DEFAULT_OPTION);
					System.exit(0);
                }
            }
        }, 0, 1000);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
    	//This value determines if the user clicked the right textbook
		boolean correct = false;
		/*Depending on the button pressed, this next part checks if a right textbook was clicked, and if
		a right one was clicked, it would change the above boolean and remove the course from the student's
		course list to avoid repeats
		*/
		if(e.getSource() == S10){
			if(currentStudent.studentCourses.contains("Science 10")){
				correct = true;
				currentStudent.studentCourses.remove("Science 10");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == SS10){
			if(currentStudent.studentCourses.contains("Social Studies 10-1")){
				correct = true;
				currentStudent.studentCourses.remove("Social Studies 10-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == M10){
			if(currentStudent.studentCourses.contains("Mathematics 10C")){
				correct = true;
				currentStudent.studentCourses.remove("Mathematics 10C");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == bio20){
			if(currentStudent.studentCourses.contains("Biology 20")){
				correct = true;
				currentStudent.studentCourses.remove("Biology 20");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == Phy20){
			//Some courses have the same textbook as another course, and this code accounts for that
			if(currentStudent.studentCourses.contains("Physics 20") || currentStudent.studentCourses.contains("Physics 30")){
				correct = true;
				if(currentStudent.studentCourses.contains("Physics 20")){
					currentStudent.studentCourses.remove("Physics 20");
					showCurrentStudent(currentStudent);
				}
				else{
					currentStudent.studentCourses.remove("Physics 30");
					showCurrentStudent(currentStudent);
				}
			}
		}

		else if(e.getSource() == ELA10){
			if(currentStudent.studentCourses.contains("English Language Arts 10-1")){
				correct = true;
				currentStudent.studentCourses.remove("English Language Arts 10-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == Chem20){
			//Again a textbook with two courses
			if(currentStudent.studentCourses.contains("Chemistry 20") || currentStudent.studentCourses.contains("Chemistry 30")){
				correct = true;
				if(currentStudent.studentCourses.contains("Chemistry 20")){
					currentStudent.studentCourses.remove("Chemistry 20");
					showCurrentStudent(currentStudent);
				}
				else{
					currentStudent.studentCourses.remove("Chemistry 30");
					showCurrentStudent(currentStudent);
				}
			}
		}

		else if(e.getSource() == ELA20){
			if(currentStudent.studentCourses.contains("English Language Arts 20-1")){
				correct = true;
				currentStudent.studentCourses.remove("English Language Arts 20-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == SS20){
			if(currentStudent.studentCourses.contains("Social Studies 20-1")){
				correct = true;
				currentStudent.studentCourses.remove("Social Studies 20-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == M20){
			if(currentStudent.studentCourses.contains("Mathematics 20-1")){
				correct = true;
				currentStudent.studentCourses.remove("Mathematics 20-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == bio30){
			if(currentStudent.studentCourses.contains("Biology 30")){
				correct = true;
				currentStudent.studentCourses.remove("Biology 30");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == ELA30){
			if(currentStudent.studentCourses.contains("English Language Arts 30-1")){
				correct = true;
				currentStudent.studentCourses.remove("English Language Arts 30-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == SS30){
			if(currentStudent.studentCourses.contains("Social Studies 30-1")){
				correct = true;
				currentStudent.studentCourses.remove("Social Studies 30-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == M30){
			if(currentStudent.studentCourses.contains("Mathematics 30-1")){
				correct = true;
				currentStudent.studentCourses.remove("Mathematics 30-1");
				showCurrentStudent(currentStudent);
			}
		}

		else if(e.getSource() == M31){
			if(currentStudent.studentCourses.contains("Mathematics 31")){
				correct = true;
				currentStudent.studentCourses.remove("Mathematics 31");
				showCurrentStudent(currentStudent);
			}
		}

		//Depending on if the correct textbook was clicked, +10 points for correct, -5 for incorrect
		if (correct == true){
			Main.points += 10;
		}
		else{
			Main.points -= 5;
		}
		thePoints.setText("Points:" + Main.points);
		
		if(currentStudent.studentCourses.isEmpty() == true){
			/*If the student's course list is empty, that means they got all their books, so we will get the 
			next person in line*/
			try {
				studentsHelped++;
				currentStudent = Main.newStudentQueue.addStudent();
				showCurrentStudent(currentStudent);
				label.setText(Main.newStudentQueue.printQueue());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	

}