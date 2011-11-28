/*
 * Providers.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class mantains a collection of providers ordered by provider name.
 */

import java.util.*;

public class Providers extends TreeMap<String, Provider> {
    
    //Inserts a new Provider into the collection.
    public boolean addProvider(Provider p)
    {
        if(!this.containsKey(p.getName()))
        {
            this.put(p.getName(), p);
            return true;
        }
        else return false;
    }
    
    //Finds a provider given a provider name.  Returns null if not found.
    public Provider find(String name)
    {
        return this.get(name);
    }
    
    //Returns the list of all providers in the collection.
    public String toString()
    {
        String str = "";
      Set   providers = this.keySet( );
      
      Iterator itr = providers.iterator( );
      
      while( itr.hasNext( ) )
      {
         str += this.get( itr.next( ) ).toString( ) + "\n";
      }
      return str;
    }
    
}
