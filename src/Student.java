import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Student {
	//Each student has a name, a grade, and their courses with respect to their grade
	String studentName;
	int studentGrade;
	ArrayList<String> studentCourses;
	static Random rand = new Random();
	public static HashMap<String, String> dict = new HashMap<String, String>();
	
	public Student(String name, int grade, ArrayList<String> courses) {
		//Constructor
		studentName = name;
		studentGrade = grade;
		studentCourses = courses;
	}
	
	public static int generateGrade() {
		//Generates a random grade for the student
		int[] grades = {10, 11, 12};
		int gradeIndex = rand.nextInt(3);
		int grade = grades[gradeIndex];
		return grade;
	}
	
	public static String generateName() throws FileNotFoundException {
		//Generates a random name with the file names.txt that I downloaded off the internet
		Scanner reader = new Scanner(new File("names.txt"));
		ArrayList<String> names = new ArrayList<String>();
		while (reader.hasNext()) {
			//Adds all names to an ArrayList
			names.add(reader.next());
		}
		//Uses a random number and gets the name corresponding to that index
		int nameIndex = rand.nextInt(names.size());
		String name = names.get(nameIndex);
		return name;
	}
	
	public static ArrayList<String> generateCourses(int grade) throws FileNotFoundException {
		//Generates courses for the student
		ArrayList<String> courses = new ArrayList<String>();
		Scanner reader2 = new Scanner(new File("Courses.txt"));
		ArrayList<String> courseNames = new ArrayList<String>();

		//Uses a HashMap hold the course name and its respective textbook
		//Will use later
	    while(reader2.hasNextLine()) {
	    	String cAndT = reader2.nextLine();
		    String[] splited = cAndT.split("/");

		    String courseName = splited[0];
		    String courseTextbook = splited[1];
		    courseNames.add(courseName);
		    
		    dict.put(courseName, courseTextbook);
	    }
		ArrayList<Integer> list = new ArrayList<Integer>();
	    if (grade == 10) {
			/*If grade 10, we only use the first 4 courses since the Courses.txt file has grade 10 courses first
			followed by grade 11 and 12*/
	    	int size = 3;
	        for(int i = 0; i <= size; i++) {
				//Adds all potential indexes to list
	            list.add(i);
	        }

	        Random rand = new Random();
	        while(list.size() > 0) {
				/*Use a random number to get the a number by index in the list, 
				which is the value that corresponds to the index of the course*/
	            int index = rand.nextInt(list.size());
	            int chosen = list.remove(index);
	            courses.add(courseNames.get(chosen));
	        }
	    }
	    else if (grade == 11) {
			//Grade 11 courses are between 5 and 10
	    	int size = 9;
	        for(int i = 4; i <= size; i++) {
				//Same process used for grade 10
	            list.add(i);
	        }

	        Random rand = new Random();
			//counter is used to ensure only 4 courses are picked
	        int counter = 0;
	        while(list.size() > 0 && counter < 4) {
	            int index = rand.nextInt(list.size());
	            int chosen = list.remove(index);
	            courses.add(courseNames.get(chosen));
	            counter++;
	        }
	    }
	    else if (grade == 12) {
			//Grade 12 courses are between 11 and 17
	    	int size = 16;
	        for(int i = 10; i <= size; i++) {
				//Same process used for grade 10
	            list.add(i);
	        }

	        Random rand = new Random();
	        int counter = 0;
	        while(list.size() > 0 && counter < 4) {
	            int index = rand.nextInt(list.size());
	            int chosen = list.remove(index);
	            courses.add(courseNames.get(chosen));
	            counter++;
	        }
	    }
		//Sorts into alphabetical order
	    Collections.sort(courses);
	    return courses;
	}
	
	public static Student generateStudent() throws FileNotFoundException {
		//Combines all methods above to generate a student
		int theGrade = Student.generateGrade();
		return new Student(Student.generateName(), theGrade, Student.generateCourses(theGrade));
	}

}