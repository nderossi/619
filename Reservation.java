/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Reservation.java
 * 
 * ******IN PROGRESS********
 * Scheduling device for people to reserve a tour offering. 
 * Also helps offerings keep track of people and available space
 */

public class Reservation{
  
   //----------------instance variables--------------
   Offering offer;
   Person p;
   
   
   //----------------constructor( Person, Offering )--------------
   public Reservation( Person per, Offering o ){ //include person later
      
      if( o == null )
         offer = new Offering(null, 0, 0, 0);
      else
         offer = o;
      
      // updated to Person object 11/29: nd
      p = per;

      // use PersonStrat here to check reservation
      //  with the Person's collection to check for
      //  conflictions
      
      offer.addReserv( this );
   }
   
   //--------------------Person getPerson()---------------------
   //***************CHANGE TO PERSON********************
   public String getPerson(){
      return p;
   }
   
   //--------------------Offering getOffering()---------------------
   public Offering getOffering(){
      return offer;
   }
   
   //--------------------------cancel()-----------------------------
   //cancel this reservation with the offering
   //*****************CANCEL WITH PERSON*********************
   public void cancel(){
      offer.removeReserv( this );
   }
   
   
   
   public String toString(){
      return "Reservation of: " + offer + "For: " + p.toString();
   }
   
}
