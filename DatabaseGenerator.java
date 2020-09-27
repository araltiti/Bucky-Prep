import java.io.FileNotFoundException;

public class DatabaseGenerator<KeyType,ValueType> extends HashTableMap<KeyType, ValueType>{

	private CourseGenerator courses;
	private HashTableMap<String, Object[]> database;

	public DatabaseGenerator() {
		try {
			this.courses = new CourseGenerator("CourseNames.txt", "TextbookNames.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("Please type in existing filenames!");
		}
		generateDatabase();
	}

	private void generateDatabase() {
		Course[] arr = courses.getCourses();

		this.database = new HashTableMap<>();

		for(Course i : arr) {
			Object[] courseInfo = new Object[3];

			String courseID = i.getCourseID();

			courseInfo[0] = i.getCourseName();
			courseInfo[1] = i.getPrerequisiteCourses();
			courseInfo[2] = i.getTextbooks();
			database.put(courseID, courseInfo);
		}

	}
}
