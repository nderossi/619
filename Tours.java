/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Tours.java
 * 
 * ******IN PROGRESS*****
 * Collection of reservations, extends ArrayList no methods
 * are overridden
 * 
 */

import java.util.*;

public class Tours extends TreeMap<String,Tour>{

   public void addTour( Tour t )
   {
     if( t != null )
       super.put( t.id(), t );
   }
   
   //--------------------Tour get( String )----------------------'
   //finds the tour with the specified id
   public Tour get( String id ){
      
      if( id == null )
         return null;
      return( super.get( id ) );
      
   }

   //--------------------Tour get( String )----------------------'
   //finds the tour with the specified id
   public void remove( String id ){
      
      if( id == null )
         return;
      
      super.remove( id );

   }

  public String toString()
  {
    StringBuilder sB = new StringBuilder();
    for( Map.Entry< String, Tour > e : this.entrySet() )
      sB.append( e.getValue() );
    return( sB.toString() );
  }
   
}
