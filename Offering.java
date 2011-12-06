/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Offering.java
 * 
 * *****IN PROGRESS*****
 * Keeps track of a specific tour 
 * (has concrete start and end date)
 */

import java.util.*;

public class Offering{
   
   //----------------instance variables--------------
   //Providers Collection
   Tour tour;
   private GregorianCalendar startDate, endDate;
   int openSlots;
   Reservations reservs;
   int year, month, day;
   
   //--------------------contructor( tour, *DATE*)------------
   //include start date
   public Offering( Tour t, int y, int m, int d){
      
      if( t == null )
         tour = new Tour( "", "", "", "" );
      else
         tour = t;
      
      year = y;
      month = m;
      day = d;
      int openSlots = tour.maxTravelers();
      startDate = new GregorianCalendar( year, month, day );
      endDate = new GregorianCalendar( year, month, day + (tour.numDays() - 1) );
      
      reservs = new Reservations();
   }
   
   //--------------------GregorianCalendar getStart()-------------------
   public GregorianCalendar getStart(){
      return startDate;
   }
   
   //--------------------GregorianCalendar getEnd()--------------------
   public GregorianCalendar getEnd(){
      return endDate;
   }
   
   //--------------------int fitnessReq()------------
   public int fitnessReq(){
      return tour.fitnessReq();
   }
   
   //--------------------int openSlots()------------
   public int openSlots(){
      return openSlots;
   }
   
   //--------------------Tour getTour()------------
   public Tour getTour(){
      return tour;
   }
   
   
   //--------------------changeDate(int, int, int)------------
   //changes the start and end date of the tour
   public void changeDate(int y, int m, int d ){
      year = y;
      month = m;
      day = d;
      startDate.set( year, month, day );
      endDate.set( year, month, day + (tour.numDays() - 1)  );
   }
   
   //--------------------updateDate()------------
   //changes the end date of the tour (based on how it has changed in tour)
   public void updateDate(){
      endDate.set( year, month, day + (tour.numDays() - 1)  );
   }
   
   //--------------------addReserv(Reservation)------------
   //add reservation to the list
   //********eventually add in checks to see if it can be added*********
   //********add another method to add with only the person (when class available)********
   public void addReserv(Reservation r){
      if( r != null ){
         reservs.add( r );
         openSlots--;
         tour.getEvents().updateEventProviders( reservs.size() );
      }
   }
   
    
   //--------------------removeReserv(Reservation)------------
   //remove reservation from the list
   public void removeReserv(Reservation r){
      if( r != null ){
         reservs.remove( r );
         openSlots++;
         tour.getEvents().updateEventProviders( reservs.size() );
      }
   }
   
   //--------------------changeSlots(int)------------
   //update the slots left in the tour 
   public void changeSlots(int dif){
      openSlots += dif - tour.maxTravelers();
   }
   
   //------------------cancel()-------------------------
   //for when it is removed from a tour, cancels all reservations
   public void cancel(){
      reservs.cancelAll();
   }
   
   public String reservsInfo(){
      return reservs.toString();
   }
   
   
   public String toString(){
      
      return "Tour: " + tour.id() + "\n Start Date: " + startDate.getTime() + "\t End Date: " + endDate.getTime() + "\n";
      
   }
   
   


}
