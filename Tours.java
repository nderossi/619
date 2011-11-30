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

public class Tours extends ArrayList<Tour>{
   
   //--------------------Tour get( String )----------------------'
   //finds the tour with the specified id
   public Tour get( String id ){
      
      if( id == null )
         return null;
      
      for( int i = 0; i < size(); i++ ){
         if( id.equals( get(i).id() )) 
               return get(i);
      }
      
      return null;
      
   }

   //--------------------Tour get( String )----------------------'
   //finds the tour with the specified id
   public void remove( String id ){
      
      if( id == null )
         return;
      
      for( int i = 0; i < size(); i++ ){
         if( id.equals( get(i).id() ) )
               remove(i);
      }

   }
   
}
