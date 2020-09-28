/**
 * Course that is used to implement our hashtable
 * 
 * @author Jacob Ware
 *
 */
public class Course {
  private final String COURSE_NAME;
  private final String COURSE_ID;
  private final Course[] PREREQUISITE_COURSES;
  private final Textbook[] TEXTBOOKS;

  /**
   * Creates a new Course object with the information passed as arguments
   * 
   * @param courseName    the name of the course
   * @param courseID      the id for the course
   * @param prerequisites prerequisite courses
   * @param textbooks     required textbooks
   */
  public Course(String courseName, String courseID, Course[] prerequisites, Textbook[] textbooks) {
    COURSE_NAME = courseName;
    COURSE_ID = courseID;
    PREREQUISITE_COURSES = prerequisites;
    TEXTBOOKS = textbooks;
  }

  /**
   * Getter method for the course name
   * 
   * @return course name
   */
  public String getCourseName() {
    return COURSE_NAME;
  }

  /**
   * Getter method for the course ID
   * 
   * @return course ID
   */
  public String getCourseID() {
    return COURSE_ID;
  }

  /**
   * Getter method for the course prerequisites
   * 
   * @return prerequisite courses
   */
  public Course[] getPrerequisiteCourses() {
    return PREREQUISITE_COURSES;
  }

  /**
   * Getter method for the required textbook(s)
   * 
   * @return required textbook(s)
   */
  public Textbook[] getTextbooks() {
    return TEXTBOOKS;
  }

  /**
   * Creates a string representation of Course that combines the courseId and courseName separated
   * by a dash
   * 
   * @return the course id and name separated by a dash
   */
  public String toString() {
    return COURSE_ID + "-" + COURSE_NAME;
  }

  /**
   * Checks if courseId passed as parameter matches the courseId of the Course it is being called on
   * 
   * @param courseID the ID to compare to
   * @return true if course IDs match, false otherwise
   */
  public boolean hasCourseID(String courseID) {
    if (COURSE_ID.equals(courseID)) {
      return true;
    } else {
      return false;
    }
  }
}
