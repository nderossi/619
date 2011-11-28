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
    protected float fitnessLevel;       //Fitness level required for activity.
    
    //Constructor
    public ActivityEvent(String n, GregorianCalendar s, GregorianCalendar e,
            float f)
    {
        super(n, s, e);
    }
    
    //Returns the fitness level required for the activity.
    public float getFitness() { return fitnessLevel; }
    
    
}
