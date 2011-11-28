/*
 * Provider.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This class represents a provider that provides services for an event.
 */

import java.util.*;


public class Provider {
    //--------------------Instance Variables------------------------
    protected String name;              //Provider name.
    protected GregorianCalendar open;   //Time that the provider opens.
    protected GregorianCalendar close;  //Time that the provider closes.
    protected int capacity;             //Provider capacity.
    
    //Constructor
    public Provider(String n, GregorianCalendar o, GregorianCalendar c,
            int cap)
    {
        name = n;
        open = o;
        close = c;
        capacity = cap;
    }
    
    //Returns the provider name.
    public String getName() { return name; }
    
    //Returns the opening time for the provider.
    public GregorianCalendar getOpenTime() { return open; }
    
    //Returns the closing time for the provider.
    public GregorianCalendar getClosingTime() { return close; }
    
    //Returns the maximum capacity for the provider.
    public int getCapacity() { return capacity; }
    
    //Returns string representation of the provider.
    public String toString()
    {
        String s = "";
        s += "Name: " + name + " Open: " + open.get(Calendar.HOUR_OF_DAY) + ":" 
                + open.get(Calendar.MINUTE) + " Close: " 
                + close.get(Calendar.HOUR_OF_DAY) + ":" 
                + close.get(Calendar.MINUTE);
        return s;
    }
}
