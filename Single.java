/**
 * Single.java
 *
 *  This class is designed to model a Single person for
 * the tour scheduling simulator group application.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

public class Single extends Person
{

  /**
   * Constructor for a Single person object
   *  Parameters are:
   *   name, age, gender, fitLevel
   */
  public Single( String n, int a, char s, int f )
  {
    super( n, a, s, f );
    type = 1;
  }

  /**
   * Method to return a String representation
   * of a Single object
   *  Return type: String
   */
  public String toString()
  {
    String str = "";
    str += "Single:\n " + super.toString();
    return( str );
  }

}
