/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Offerings.java
 * 
 * *****IN PROGRESS*****
 * Collection of offerings, extends ArrayList
 */

import java.util.*;

public class Offerings extends ArrayList<Offering>{
   
   
   //--------------------remove( int, int, int )----------------------'
   //removes the offering at the passed in start date
   public void remove( int year, int month, int day ){
    
      //get the passed in date
      GregorianCalendar c = new GregorianCalendar( year, month, day );
      Date d = c.getTime();
      
      //find and remove it
      for( int i = 0; i < size(); i++){
         if( d.equals( get(i).getStart().getTime() )){
            remove( i );
         }
      }
   }

   
   //--------------------Offering get( int, int, int )----------------------
   //get the offering that matches the date description
   public Offering get( int year , int month , int day ){
      
      //get the passed in date
      GregorianCalendar c = new GregorianCalendar( year, month, day );
      Date d = c.getTime();
      
      //find and remove it
      for( int i = 0; i < size(); i++){
         if( d.equals( get(i).getStart().getTime() ))
            return get( i );
      }
      
      return null;

   }
   
   
   //-------------------update()-------------------------------
   //update the date on all the offerings
   public void update(){
      for( int i = 0; i < size(); i++){
         get(i).updateDate();
      }
      
   }
   
   
   //-------------------changeSlots(int)-------------------------------
   //update the open slots for all offerings
   public void changeSlots(int dif){
      for( int i = 0; i < size(); i++){
         get(i).changeSlots(dif);
      }
      
   }
   
  /**
   * toString() method for this collection
   */
  public String toString()
  {
    StringBuilder sB = new StringBuilder();
    for( Offering o : this )
      sB.append( o );
    return( sB.toString() );
  }
   
   
}
