/**
 * Double.java
 *
 *  This class is designed to model a set of 2 Person
 * objects, known as a Double.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

public class Double extends Person
{
 
  // instance variables 
  private Person p1;
  private Person p2;

  /**
   * Constructor for Double object
   *  Parameters are 2 Person objects
   */
  public Double( Person per1, Person per2 )
  {
    super( per1.getName(), per1.getAge(), per1.getGender(), per1.getFit() );
    p1 = per1;
    p2 = per2;
    type = 2;
    name = p1.getName() + ", ";
    name += p2.getName();
  }

  /**
   * Method to return a String representation
   *  of the Double object.
   */
  public String toString()
  {
    String str = "Double:\n";
    str += "Name = " + p1.getName() + ", Age = ";
    str += p1.getAge() + ", Gender = " + p1.getGender();
    str += ", FitLevel = " + p1.getFit();
    str += "\nReservations:\n" + p1.res.toString();
    str += "Name = " + p2.getName() + ", Age = ";
    str += p2.getAge() + ", Gender = " + p2.getGender();
    str += ", FitLevel = " + p2.getFit();
    str += "\nReservations:\n" + p2.res.toString();
    return( str );
  }

}
