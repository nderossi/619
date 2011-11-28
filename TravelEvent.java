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
    
    //Constructor
    public TravelEvent(String n, GregorianCalendar s, GregorianCalendar e,
            String d)
    {
        super(n, s, e);
        destination = d;
    }
    
    //Returns  the destination name.
    public String getDestination() { return destination; }
    
    //Returns string representation of the TravelEvent.
    public String toString()
    {
        String s ="";
        s += name + " to " + destination + " " 
                + startTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + startTime.get(Calendar.MINUTE) + " to "
                + endTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + endTime.get(Calendar.MINUTE);
        return s;
    }
}
