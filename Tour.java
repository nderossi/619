/*
 * Tyler Janowski
 * CS 619 Group Project
 * Other Members: Nick Grauel, Nick DeRossi
 * 
 * Tour.java
 * 
 * ********IN PROGRESS********
 * Tour object that defines the general
 * layout for a tour
 */

public class Tour{ //implements TourStrat
   
   //----------------instance variables--------------
   //Event Collection for each day
   //Start Place;
   //End Place;
   private Offerings offers;
   private int maxTravelers;
   private int days;
   private int fitRating;
   private String company;
   private String id;
   
   
   //--------------------constructor(String)-----------------
   //set company name to passed String, other data set to 0
   public Tour( String comp, String s ){
      
      if( comp == null )
         company = "";
      else
         company = comp;
      
      if( s == null )
         id = "";
      else
         id = s;
      
      maxTravelers = 0;
      days = 0;
      fitRating = 0;
      
      offers = new Offerings();
   }
   
   //--------------------constructor(String, int, int, int)-----------------
   //set all data
   public Tour( String comp, String s, int t, int d, int fit ){
      
      if( comp == null )
         company = "";
      else
      company = comp;
      
      if( s == null )
         id = "";
      else
         id = s;
      
      maxTravelers = t;
      days = d;
      fitRating = fit;
      
      offers = new Offerings();
      
   }
   
   
   //---------------------String company()------------------
   public String company(){
      return company;
   }
   
   //---------------------findOffering(int, int, int)------------------
   //finds the offering at the specified date
   public Offering findOffering( int year, int month, int day ){
      return offers.get( year, month, day );
   }
   
   //---------------------int maxTravelers()------------------
   public int maxTravelers(){
      return maxTravelers;
   }
   
   //---------------------int numDays()------------------
   public int numDays(){
      return days;
   }
   
   //---------------------int numDays()------------------
   public String id(){
      return id;
   }
   
   //---------------------int fitnessReq()------------------
   public int fitnessReq(){
      return fitRating;
   }
   
   //---------------------addOffering(int, int, int)------------------
   //adds an offering to the collection
   public void addOffering( int year, int month, int day ){
      Offering o = new Offering( this, year, month, day );
      offers.add( o );
   }
   
   //---------------------removeOffering(int, int, int)------------------
   //removes the offering from the collection
   public void removeOffering( int year, int month, int day ){
      if( offers.get( year, month, day ) != null ){
         offers.get( year, month, day ).cancel();
         offers.remove( year, month, day );
      }
   }
   
   //---------------------setMax(int)------------------
   public void setMax( int max ){
      offers.changeSlots( max );
      maxTravelers = max;
   }
   
   //---------------------setFitness(int)------------------
   public void setFitness( int fit ){
      fitRating = fit;
   }
   
   //---------------------setFitness(int)------------------
   public void setNumDays( int d ){
      days = d;
      offers.update();
   }
   
   public String toString(){
      
      String s = "Tour " + id() + " by: " + company() + "\n";
      s += numDays() + " days long\t\tFitness Level Required: ";
      s += fitnessReq() + "\tMaximum Capacity: " + maxTravelers();
      
      s += "\nOfferings: " + offers.toString();
      
      return s;
   }
   
   
}