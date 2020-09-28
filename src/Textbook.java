/**
 * Textbook used in Course
 * 
 * @author Jacob Ware
 *
 */
public class Textbook {
  private final String TEXTBOOK_NAME;
  private final int TEXTBOOK_ISBN;

  /**
   * Creates a Textbook object with the passed name and isbn
   * 
   * @param name name to be assigned to Textbook
   * @param isbn isbn to be assigned to Textbook
   */
  public Textbook(String name, int isbn) {
    TEXTBOOK_NAME = name;
    TEXTBOOK_ISBN = isbn;
  }

  /**
   * Returns a string of the textbok name and isbn separated by a dash
   * 
   * @return the name and isbn separated by a dash
   */
  public String toString() {
    return TEXTBOOK_NAME + " (ISBN:" + TEXTBOOK_ISBN + ")";
  }

  /**
   * Getter method for the textbook name
   * 
   * @return textbook name
   */
  public String getName() {
    return TEXTBOOK_NAME;
  }

  /**
   * Getter method for the textbook isbn
   * 
   * @return textbook isbn
   */
  public int getISBN() {
    return TEXTBOOK_ISBN;
  }
}
