/*
 * TravelEvent.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class represents an event that consists of traveling to a destination.
 */

import java.util.*;

public class TravelEvent extends Event{
    //-----------------------Instance Variables------------------------
    protected String destination;       //Destination name.
    protected String startLocation;     //Start location name
    
    //Constructor
    public TravelEvent(String n, String st, String d, GregorianCalendar s,
           GregorianCalendar e )
    {
        super(n, s, e);
        destination = d;
        startLocation = st;
    }
    
    //Returns  the destination name.
    public String getDestination() { return destination; }

    //Returns the startLocation name
    public String getStartLocation() { return startLocation; }
    
    //Returns string representation of the TravelEvent.
    public String toString()
    {
        String s ="";
        s += name + " from " + startLocation + " to " + destination + " " 
                + startTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + startTime.get(Calendar.MINUTE) + " to "
                + endTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + endTime.get(Calendar.MINUTE);
        return s;
    }
}
