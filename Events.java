/*
 * Events.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class mantains a collection of events ordered by event name.
 */

import java.util.*;

public class Events extends TreeMap<String, Event>{
    
    //Adds an event to the collection.
    public boolean addEvent(Event e)
    {
        if(!this.containsKey(e.getName()))
        {
            this.put(e.getName(), e);
            return true;
        }
        else return false;
    }
    
    //Finds an event given the event name.
    public Event find(String name)
    {
        return this.get(name);
    }
    
    //Returns the list of all providers in the collection.
    public String toString()
    {
        String str = "";
      Set   events = this.keySet( );
      
      Iterator itr = events.iterator( );
      
      while( itr.hasNext( ) )
      {
         str += this.get( itr.next( ) ).toString( ) + "\n";
      }
      
      return str;
    }
    
}
