/**
 * Commander.java
 *
 *  This class is designed to be to command interpreter
 * and pareser.  The keyword is initially parsed and
 * the appropriate method is called.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

import java.util.*;
import java.io.*;

public class Commander
{
  
  // instance variable
  private Scanner s = null;
  private People pers;
  private Providers ps;

  /**
   * Constructor for the command processor
   *  Paremeter is a Scanner object
   */
  public Commander( Scanner sc )
  {
    s = sc;
    pers = new People();
    ps = new Providers();
  }

  /**
   * Method to handle the actual keyword
   *  identification and parsing.
   */
  public void action()
  {
    String input = null;
    while( s.hasNext() )
    {
      input = s.next();
      if( input.equals( "person" ) )
        definePerson();
      else if( input.equals( "provider" ) )
        defineProvider();
      else if( input.equals( "#" ) )
        System.out.println( "#" + s.nextLine() );
      else
        s.nextLine();
    }
    System.out.println( "\nPeople:\n----------------" );
    System.out.println( pers.toString() );
    System.out.println( "Providers:\n---------------" );
    System.out.println( ps.toString() );
  }

  /**
   * Method to parse and define the
   * person object.
   */
  public void definePerson()
  {
    Person p = null;
    String type = s.next();
    String name = s.next();
    int age = s.nextInt();
    String gender = s.next();
    int fitLevel = s.nextInt();
    if( type.equals( "solo" ) )
      p = new Solo( name, age, gender, fitLevel );
    else if( type.equals( "single" ) )
      p = new Single( name, age, gender, fitLevel );
    else if( type.equals( "double" ) )
    {
      String name2 = s.next();
      int age2 = s.nextInt();
      String gender2 = s.next();
      int f2 = s.nextInt();
      Person tmp = new Single( name, age, gender, fitLevel );
      p = new Double( tmp, new Single( name2, age2, gender2, f2 ) );
    }
    else
      System.out.println( "Invalid person type!" );
    pers.insertPerson( p );
    s.nextLine();
  }
  
  /**
   * method to define a provider object
   *  according to the file input
   */
  public void defineProvider()
  {
    String serv = s.next();
    String name = s.next();
    String location = s.next();
    int cap = s.nextInt();
    int opTime = s.nextInt();
    int clTime = s.nextInt();
    int secs = opTime%100;
    opTime = opTime/100;
    int hours = opTime%100;
    GregorianCalendar op = new GregorianCalendar( 2011, 11, 29, hours, secs );
    secs = clTime%100;
    clTime = clTime/100;
    hours = clTime%100;
    GregorianCalendar cl = new GregorianCalendar( 2011, 11, 29, hours, secs );
    Provider p = new Provider( name, op, cl, cap ); // need to add location
    ps.addProvider( p );
  }

}
