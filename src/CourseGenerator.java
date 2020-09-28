import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Used to generate courses for the course hash table
 * 
 * @author Jacob Ware
 *
 */
public class CourseGenerator {
  private Scanner courseNameScanner;
  private Scanner textbookNameScanner;
  private Scanner courseIDScanner;
  private ArrayList<String> courseNames;
  private ArrayList<String> textbookNames;
  private ArrayList<Course> createdCourses;
  private ArrayList<String> courseIDs;
  private Random random;
  private final int MAX_PREREQUISITES = 3;
  private final int MAX_TEXTBOOKS = 2;

  /**
   * Creates a new courseGenerator that takes in its info from the file names passed as arguments
   * 
   * @param courseFileName   name of the file where the course names are located
   * @param textbookFileName name of the file where the textbook names are located
   * @throws FileNotFoundException only thrown if incorrect file names are passed as arguments
   */
  public CourseGenerator(String courseFileName, String textbookFileName, String courseIDFileName)
      throws FileNotFoundException {
    File courseFile = new File(courseFileName);
    File textbookFile = new File(textbookFileName);
    File courseIDFile = new File(courseIDFileName);
    random = new Random();

    courseNameScanner = new Scanner(courseFile);
    textbookNameScanner = new Scanner(textbookFile);
    courseIDScanner = new Scanner(courseIDFile);

    createdCourses = new ArrayList<>();
    courseIDs = new ArrayList<>();

    loadCourseNames();
    loadTextbookNames();
    loadCourseIDs();
    createCourses();
  }

  /**
   * Loads course IDs from a txt document
   */
  private void loadCourseIDs() {
    while (courseIDScanner.hasNextLine()) {
      courseIDs.add(courseIDScanner.nextLine());
    }
  }
  /**
   * Loads the course names from a txt document
   */
  private void loadCourseNames() {
    courseNames = new ArrayList<>();
    while (courseNameScanner.hasNextLine()) {
      courseNames.add(courseNameScanner.nextLine());
    }
  }

  /**
   * Loads the textbook names from a txt document
   */
  private void loadTextbookNames() {
    textbookNames = new ArrayList<>();
    while (textbookNameScanner.hasNextLine()) {
      textbookNames.add(textbookNameScanner.nextLine());
    }
  }

  /**
   * Creates new courses until there are no course names available. Stores those courses in the
   * createdCourses ArrayList
   */
  private void createCourses() {
    while (courseNames.size() > 0) {
      int randomIndex = Math.abs(random.nextInt()) % courseNames.size();

      String name = courseNames.get(randomIndex);
      courseNames.remove(randomIndex);

      String courseID = createNewCourseID();

      Course[] prerequisiteCourses = getPrerequisiteCourses();

      Textbook[] textbooks = createTextbooks();

      Course newCourse = new Course(name, courseID, prerequisiteCourses, textbooks);
      createdCourses.add(newCourse);
    }
  }

  /**
   * Getter method for an ArrayList of all the created courses
   * 
   * @return ArrayList of all created courses
   */
  public Course[] getCourses() {
    Course[] courseArray = new Course[createdCourses.size()];
    
    for (int i = 0; i < createdCourses.size(); i++) {
      courseArray[i] = createdCourses.get(i);
    }
    
    return courseArray;
    
  }

  /**
   * Creates a new course with between 2 and 4 letters along with a random number between 100 and
   * 999
   * 
   * @return the newly created course id
   */
  private String createNewCourseID() {
    
    int randomIndex = random.nextInt(courseIDs.size());
    String courseID = courseIDs.get(randomIndex);
    courseIDs.remove(randomIndex);
    
    return courseID;
  }  

  /**
   * creates an array of textbooks that are to be used for Courses. Courses will always have
   * MAX_TEXTBOOKS. ISBN is a random number between 10,000,000 and 1,009,999,999
   * 
   * @return the array of Textbooks
   */
  private Textbook[] createTextbooks() {
    Textbook[] textbooks = new Textbook[MAX_TEXTBOOKS];

    for (int i = 0; i < MAX_TEXTBOOKS; i++) {
      textbooks[i] =
          new Textbook(textbookNames.get(Math.abs(random.nextInt()) % textbookNames.size()),
              random.nextInt(1000000000) + 10000000);
    }

    return textbooks;
  }

  /**
   * Creates an array of courses. Courses are drawn from previously created courses. The returned
   * array will have all of its elements at the front meaning that once a null entry is reached
   * there are no more non-null entries at the following indices.
   * 
   * @return the prerequisite courses for another course
   */
  private Course[] getPrerequisiteCourses() {
    ArrayList<Course> usedCourses = new ArrayList<>();
    Course[] prereqs = new Course[MAX_PREREQUISITES];

    if (createdCourses.size() == 0) {
      return prereqs;
    }

    int numPrerequisites = random.nextInt(MAX_PREREQUISITES + 1);

    for (int i = 0; i < numPrerequisites && i < createdCourses.size(); i++) {
      int randomIndex = Math.abs(random.nextInt()) % createdCourses.size();
      boolean sameCourse = false;

      for (int j = 0; j < usedCourses.size(); j++) {
        if (usedCourses.get(j).equals(createdCourses.get(randomIndex))) {
          i--;
          sameCourse = true;
          break;
        }
      }

      if (sameCourse) {
        break;
      }

      prereqs[i] = createdCourses.get(randomIndex);
      usedCourses.add(createdCourses.get(randomIndex));
    }

    return prereqs;
  }

}

