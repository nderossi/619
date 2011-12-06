/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Reservations.java
 * 
 * ********IN PROGRESS********
 * Collection of reservations, extends ArrayList no methods
 * are overridden
 */

import java.util.*;

public class Reservations extends ArrayList<Reservation>{
   
   //------------------------cancelAll()----------------
   //cancel all reservations in the list
   public void cancelAll(){
      for( int i = 0; i < size(); i ++ ){
         get(i).cancel();
      }
      clear();
   }
   
   //------------------------cancel(Offering)----------------
   //cancel the reservation that matches the current offering
   //********************MAKE ANOTHER FOR PERSON*************
   public void cancel( Offering o ){
      
      if( o == null )
         return;
      
      for( int i = 0; i < size(); i ++){
         if( o.getTour().id().equals( get(i).getOffering().getTour().id() ) 
               && o.getStart().getTime().equals( get(i).getOffering().getStart().getTime() )){
            get(i).cancel();
            remove(i);
         }
      }
      
   }
   
}
