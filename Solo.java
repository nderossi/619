/**
 * Solo.java
 *
 *  This class is designed to model a Solo person for
 * the tour scheduling simulator group application.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

public class Solo extends Person
{

  /**
   * Constructor for a Solo person object
   *  Parameters are:
   *   name, age, gender, fitLevel
   */
  public Solo( String n, int a, char s, int f )
  {
    super( n, a, s, f );
    type = 0;
  }

  /**
   * Method to return a String
   * representation of the Solo
   * object
   *  Return type: String
   */
  public String toString()
  {
    String str = "";
    str += "Solo:\n " + super.toString();
    return( str );
  }

}
