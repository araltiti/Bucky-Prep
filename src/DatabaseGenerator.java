// --== CS400 File Header Information ==--
// Name: Abdul Altiti
// Email: altiti@wisc.edu
// Team: AC
// Role: Back End 2
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;

public class DatabaseGenerator<KeyType,ValueType> extends HashTableMap<KeyType, ValueType>{

	private CourseGenerator courses;
	public HashTableMap<String, Course> database;

	/**
	 * Default Constructor initializes and setups the database
	 */
	public DatabaseGenerator() {
		try {
			this.courses = new CourseGenerator("CourseNames.txt", "TextbookNames.txt","courseIDs.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("Please type in existing filenames!");
		}
		generateDatabase();
	}

	/**
	 * Generates and setups the database of the courses. Utilizies HashTableMap
	 * to call put method.
	 */
	private void generateDatabase() {
		//Calls the array of the courses generated
		Course[] arr = courses.getCourses();

		this.database = new HashTableMap<>(arr.length);

		for(Course i : arr) {

			//Key Value which is the course ID
			String courseID = i.getCourseID();

			database.put(courseID, i);
		}

	}
}
