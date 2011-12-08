/*
 * ActivityEvent.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * LAST UPDATED 12/1
 * This class represents an event that is an activity with a minimum required
 * fitness level.
 */

import java.util.*;

public class ActivityEvent extends Event {
    //--------------------------Instance Variables---------------------
    protected int fitnessLevel;       //Fitness level required for activity.
    
    //Constructor
    public ActivityEvent(String n, GregorianCalendar s, GregorianCalendar e,
			 int f, int day, Providers provs, String serv, String loc )
    {
        super(n, day, s, e, provs, serv, loc);
        fitnessLevel = f;
    }
    
    //Returns the fitness level required for the activity.
    public float getFitness() { return fitnessLevel; }
    
    
}
