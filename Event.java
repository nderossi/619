/*
 * Event.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class represents a generic event.  It is the basis for the ActivityEvent
 * and TravelEvent subclasses.
 */

import java.util.*;


public class Event{
    //------------------------Instance Variables----------------------
    protected String name;                  //Event name.
    protected GregorianCalendar startTime;  //Start time for the event.
    protected GregorianCalendar endTime;    //End time for the event.
    protected Providers providers;          //Collection providers that offer 
                                            //the event.
    
    //Constructor
    public Event(String n, GregorianCalendar s, GregorianCalendar e)
    {
        name = n;
        startTime = s;
        endTime = e;
        providers = new Providers();
    }
    
    //Returns the name of the event.
    public String getName() { return name; }
    
    //Returns the start time of the event in GregorianCalendar form.
    public GregorianCalendar getStartTime() { return startTime; }
    //Returns the end time of the event in GregorianCalendar form.
    public GregorianCalendar getEndTime() { return endTime; }
    
    //Adds a provider to the collection of providers.
    public void addProvider(Provider p) { providers.addProvider(p); }
    
    //Finds a provider in the collection by name.  Returns null if not found.
    public Provider getProvider(String name) { return providers.find(name); }
    
    //Returns true if this event occurs at the same time as a given event.
    public boolean isConflicting(Event e)
    {
        boolean conflicting = false;
        //Start and end dates for this event.
        Date e1Start = startTime.getTime();
        Date e1End = endTime.getTime();
        
        //Start and end dates for argument.
        Date e2Start = e.getStartTime().getTime();
        Date e2End = e.getEndTime().getTime();
        
        //Cases where the event times would conflict.
        if(e1Start.compareTo(e2Start) < 0 && e1End.compareTo(e2Start) > 0)
            conflicting = true;
        if(e1Start.compareTo(e2End) < 0 && e1End.compareTo(e2End) > 0)
            conflicting = true;
        if(e1Start.compareTo(e2Start) < 0 && e1End.compareTo(e2End) > 0)
            conflicting = true;
        if(e1Start.compareTo(e2Start) > 0 && e1End.compareTo(e2End) < 0)
            conflicting = true;
        return conflicting;
    }
    
    /* Returns string representation of the event.  Used for events with no
     * provider.
     */
    public String toString()
    {
        String s = "";
        s += name + " from " + + startTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + startTime.get(Calendar.MINUTE) + " to "
                + endTime.get(Calendar.HOUR_OF_DAY) + ":" 
                + endTime.get(Calendar.MINUTE);
        return s;
    }
   
}
