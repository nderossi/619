/*
 * Providers.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * LAST UPDATED 12/1
 * This class mantains a collection of providers ordered by provider name.
 */

import java.util.*;

public class Providers extends ArrayList<Provider>{
    
    //Finds a provider given a provider name.  Returns null if not found.
    public Provider find(String name)
    {
        for(int x = 0; x < size(); x++)
        {
            if(get(x).getName().equals(name))
                return get(x);
        }
        return null;
    }
    
    //Returns the collection of all providers that provide the given service.
    public Providers getServiceProviders(String serv)
    {
        Providers p = new Providers();
        for(int x = 0; x < size(); x ++)
        {
            if(get(x).getService().equals(serv))
                p.add(get(x));
        }
        return p;
    }
    
    //Removes the given provider from the collection if it exists.
    public void removeProvider(Provider p)
    {
        for(int x = 0; x < size(); x++)
        {
            if(get(x).equals(p))
                remove(x);
        }
    }
    
    //Returns the list of all providers in the collection.
    public String toString()
    {
        String str = "";
        for(int x = 0; x < size(); x ++)
            str += '\n' + get(x).toString();
        return str;
    }
    
}
