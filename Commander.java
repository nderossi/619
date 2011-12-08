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
  private Tours ts;
  private Offerings os;

  /**
   * Constructor for the command processor
   *  Paremeter is a Scanner object
   */
  public Commander( Scanner sc )
  {
    s = sc;
    pers = new People();
    ps = new Providers();
    ts = new Tours();
    os = new Offerings();
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
      else if( input.equals( "tour" ) )
        defineTour();
      else if( input.equals( "offering" ) )
        defineOffer();
      else if( input.equals( "reservation" ) )
        defineReserv();
      else if( input.equals( "print" ) )
        printMethod();
      else if( input.equals( "#" ) )
        System.out.println( "#" + s.nextLine() );
      else
        s.nextLine();
    }
    System.out.println( "\nPeople:\n----------------" );
    System.out.println( pers.toString() );
    System.out.println( "\nTours:\n---------------" );
    System.out.println( ts.toString() );
    System.out.println( "Offerings:\n---------------" );
    System.out.println( os.toString() );
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
    {
      p = new Solo( name, age, gender, fitLevel );
      pers.insertPerson( p );
    }
    else if( type.equals( "single" ) )
    {
      p = new Single( name, age, gender, fitLevel );
      pers.insertPerson( p );
    }
    else if( type.equals( "double" ) )
    {
      String name2 = s.next();
      int age2 = s.nextInt();
      String gender2 = s.next();
      int f2 = s.nextInt();
      Person tmp = new Single( name, age, gender, fitLevel );
      p = new Double( tmp, new Single( name2, age2, gender2, f2 ) );
      pers.insertPerson( p );
    }
    else
      System.out.println( "Invalid person type!" );
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
    GregorianCalendar op = new GregorianCalendar( 2011, 11, 10, hours, secs );
    secs = clTime%100;
    clTime = clTime/100;
    hours = clTime%100;
    GregorianCalendar cl = new GregorianCalendar( 2011, 11, 10, hours, secs );
    Provider p = new Provider( name, serv, location, op, cl, cap );
    ps.add( p );
    updateProviders( p );
  }

  /**
   * Method to handle the parsing and
   *  declaration of a Tour object
   */
  public void defineTour()
  {
    Tour t = null;
    Event e = null;
    String comp = s.next();
    String id = s.next();
    String startLoc = s.next();
    String endLoc = s.next();
    int days = s.nextInt();
    int fit = s.nextInt();
    int cap = s.nextInt();
    int sT = 0;
    int eT = 0;
    int hours = 0;
    int secs = 0;
    s.nextLine();
    s.nextLine();
    t = new Tour( comp, id, startLoc, endLoc, cap, days, fit );
    for( int i = 0; i<days; i++ )
    {
      while( s.hasNext() && s.next().equals( "event" ) )
      {

        String tmp = s.next();

        if( tmp.equals( "travel" ) )
        {
          String mode = s.next();
          startLoc = s.next();
          endLoc = s.next();
          sT = s.nextInt();
          eT = s.nextInt();
          secs = sT%100;
          sT = sT/100;
          hours = sT%100;
          GregorianCalendar s = new GregorianCalendar( 2011, 11, 10+i, hours, secs );
          secs = eT%100;
          eT = eT/100;
          hours = eT%100;
          GregorianCalendar end = new GregorianCalendar( 2011, 11, 10+i, hours, secs );
          e = new TravelEvent( mode, startLoc, endLoc, s, end, i+1, ps, mode );
        }
        else
        {
          String act = s.next();
          sT = s.nextInt();
          eT = s.nextInt();
          fit = s.nextInt();
          secs = sT%100;
          sT = sT/100;
          hours = sT%100;
          sT = sT/100;
          GregorianCalendar s = new GregorianCalendar( 2011, 11, 10+i, hours, secs );
          secs = eT%100;
          eT = eT/100;
          hours = eT%100;
          GregorianCalendar end = new GregorianCalendar( 2011, 11, 10+i, hours, secs );
          e = new ActivityEvent( act, s, end, fit, i+1, ps, act );
        }

        if( !t.addEvent( e ) )
        {
          System.err.println( "event Does conflict" );
          return;
        }
      }
    }
    ts.addTour( t );
  }

  /**
   * This method is used to parse and correctly
   *  create, schedule, and store a tour offering.
   */
  private void defineOffer()
  {
    String tourId = s.next();
    int sDate = s.nextInt();
    int year = sDate%10000;
    sDate = sDate/10000;
    int day = sDate%100;
    sDate = sDate/100;
    int month = sDate%100;
    Tour t = ts.get( tourId );
    if( t != null )
    {
      Offering o = new Offering( t, year, month, day );
      os.add( o );
      t.addOffering( year, month, day );
    }
    else
      System.err.println( "Tour " + tourId + " has not been defined!" );
    s.nextLine();
  }

  /**
   * This method is used to parse and correctly
   *  create, schedule, and store a reservation.
   */
  private void defineReserv()
  {
    String persName = s.next();
    String tourId = s.next();
    int sDate = s.nextInt();
    int year = sDate%10000;
    sDate = sDate/10000;
    int day = sDate%100;
    sDate = sDate/100;
    int mon = sDate%100;
    Person p1 = pers.findPerson( persName );
    if( p1 != null )
    {
      Tour t1 = ts.get( tourId );
      if( t1 != null )
      {
        Offering of = t1.findOffering( year, mon, day );
        if( of != null )
        {
          Reservation r = new Reservation( p1, of );
          if( p1.getType() == 0 )
            matchSolos( p1, r );
          else if( p1.addReserv( r ) )
            System.err.println( "Confliction with current Reservation!" );
        }
      }
      else
        System.err.println( "Tour " + tourId + " has not been defined!" );
    }
    else
      System.err.println( "Person " + persName + " has not been defined!" );
    s.nextLine();
  }

  /**
   * This method is used to iterate through the collection
   *  of offerings and update each individual events'
   *  providers.
   */
   private void updateProviders( Provider p )
   {
     for( Offering o : os )
       o.addProvider( p );
   }
   
   /**
    * This method iterates through collection
    *  of defined people, if they are solos,
    *  check for specified reservation, if
    *  present check gender, if not check fit
    *  level.
    */ 
   private void matchSolos( Person p, Reservation r )
   {
     Iterator i = pers.getSoloIter();
     while( i.hasNext() )
     {
       Person pe = ( Person )i.next();
       if( pe.getType() == 0 )
       {
         if( pe.hasReservation( r ) )
         {
           if( pe.getGender().equals( p.getGender() ) )
           {
             pe = pers.removeSolo( p );
             Double d = new Double( pe, p );
             pers.insertPerson( pe );
           } 
          }
        }
      }
    }

    /**
     * This method is designed to output the
     *  offerings and reservations collections
     *  for the demonstration purposes.
     */
    private void printMethod()
    {
      System.err.println( "\nOfferings:\n---------------" );
      System.err.println( os.toString() );
      // System.err.println( "\nPeople:\n---------------" );
      // System.err.println( pers.toString() );
    }

}
