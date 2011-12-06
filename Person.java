/**
 * Person.java
 *
 *  This class is designed to model a Person for the tour
 * scheduling simulator group application.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

import java.util.*;

public class Person
{

  // instance variables
  protected String name;
  protected int age;
  protected int fitLevel;
  protected String gender;
  protected int type;
  protected Reservations res;
  
  /**
   * Constructor for Person object
   *  Parameters are:
   *   name, age, gender, fitLevel
   */
  public Person( String n, int a, String s, int f )
  {
    name = n;
    if( a <= 0 )
      a = 1;
    age = a;
    if( !s.equals( "m" ) && !s.equals( "f" ) )
      s = "m";
    gender = s;
    if( f < 0 )
      f = 0;
    fitLevel = f;
    res = new Reservations();
  }

  /**
   * Accessor for name field
   *  Return type: String
   */
  public String getName()
  {
    return( name );
  }

  /**
   * Accessor for age field
   *  Return type: int
   */
  public int getAge()
  {
    return( age );
  }

  /**
   * Accessor for gender field
   *  Return type: char
   */
  public String getGender()
  {
    return( gender );
  }

  /**
   * Accessor for fitLevel field
   *  Return type: int
   */
  public int getFit()
  {
    return( fitLevel );
  }

  /**
   * Accessor for the type field
   *  Return type: int
   */
  public int getType()
  {
    return( type );
  }

  /**
   * Method to add a reservation to
   *  person object.
   */
  public boolean addReserv( Reservation r )
  {
    res.add( r );
    return( true );
  }

  /**
   * Method to return a String
   * representation of the Person
   * object
   *  Return type: String
   */ 
  public String toString()
  {
    String str = "";
    str += "Name = " + name + ", Age = ";
    str += age + ", Gender = " + gender;
    str += ", FitLevel = " + fitLevel;
    str += "\nReservations:\n" + res.toString();
    return( str );
  }

}
