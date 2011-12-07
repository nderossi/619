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
   
   
 //--------------------addProvider(Provider)------------------
   //add possible provider to all events
   public void addProvider( Provider prov ){
	   for( int i = 0; i < size(); i++ )
		   get(i).addProvider(prov);
   }
   
   
   
   //-------------------changeSlots(int)-------------------------------
   //update the open slots for all offerings
   public void changeSlots(int dif){
      for( int i = 0; i < size(); i++){
         get(i).changeSlots(dif);
      }
      
   }
   

   
   
}