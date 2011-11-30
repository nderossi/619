/*
 * ActivityEvent.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class represents an event that is an activity with a minimum required
 * fitness level.
 */

import java.util.*;

public class ActivityEvent extends Event {
    //--------------------------Instance Variables---------------------
    protected int fitnessLevel;       //Fitness level required for activity.
    
    //Constructor
    public ActivityEvent(String n, GregorianCalendar s, GregorianCalendar e,
            int f)
    {
        super(n, s, e);
        fitnessLevel = f;
    }
    
    //Returns the fitness level required for the activity.
    public float getFitness() { return fitnessLevel; }
    
    
}
