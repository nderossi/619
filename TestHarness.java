/*
 * TestHarness.java
 * Author: Nick Grauel
 * Group: Nick Grauel, Tyler Janowski, Nick DeRossi
 * This test harness tests each of the classes I have coded: 
 *  -Event (+ subclasses)
 *  -Provider
 *  -Events 
 *  -Providers
 * It checks to make sure they can be correctly instantiated and printed, and 
 * tests the Events and Providers collections to make sure they correctly add
 * and retrieve Events/Providers.
 */

import java.util.*;

public class TestHarness {
    //------------------Instance Variables---------------------------
    protected Events events;            //Test for Events collection.
    protected Providers providers;      //Test for Providers collection.
    
    public TestHarness()
    {
        events = new Events();
        providers = new Providers();
        GregorianCalendar open = new GregorianCalendar(0,0,0, 8, 30);
        GregorianCalendar close = new GregorianCalendar(0,0,0, 17, 00);
        
        
        //Create some providers to test provider functions.
        System.out.println("Create some providers: ");
        Provider p = new Provider("Provider1", open, close, 100);
        providers.addProvider(p);
        p = new Provider("Provider2", open, close, 150);
        providers.addProvider(p);
        open = new GregorianCalendar(0,0,0,9,0);
        close = new GregorianCalendar(0,0,0,14,0);
        p = new Provider("Provider3", open, close, 225);
        providers.addProvider(p);
        System.out.println(providers.toString());
        
        
        //Create some events to test event functions.
        System.out.println("Create some events: ");
        GregorianCalendar start = new GregorianCalendar(0,0,0, 10, 00);
        GregorianCalendar end = new GregorianCalendar(0,0,0, 12, 00);
        Event e = new Event("Event1", start, end);
        events.addEvent(e);
        ActivityEvent aE = new ActivityEvent("Activity1", start, end, 10);
        events.addEvent(aE);
        start = new GregorianCalendar(0,0,0, 12, 00);
        end = new GregorianCalendar(0,0,0, 12, 45);
        TravelEvent tE = new TravelEvent("Travel1", start, end, "Destination");
        events.addEvent(tE);
        System.out.println(events.toString());
        
        
        //Try to create a duplicate provider (should fail).
        System.out.println("Try to add a duplicate provider to the "
                + "providers collection (should fail): ");
        start = new GregorianCalendar(0,0,0,10,0);
        end = new GregorianCalendar(0,0,0,12,0);
        Provider p2 = new Provider("Provider1", start, end,100);
        boolean wasAdded = providers.addProvider(p2);
        if(wasAdded)
            System.out.println("Provider was successfully added!");
        else System.out.println("Error: Duplicate provider!\n");
        
        
        //Try to create a second event of the same type/name (should fail).
        System.out.println("Try to add a duplicate event to the " 
                + "events collection (should fail):");
        start = new GregorianCalendar(0,0,0,1,00);
        end = new GregorianCalendar(0,0,0,1,30);
        ActivityEvent aE2 = new ActivityEvent("Activity1", start, end, 10);
        wasAdded = events.addEvent(aE2);
        if(wasAdded)
            System.out.println("Event added sucessfully!\n");
        else System.out.println("Error: Duplicate event!\n");
        
        
        //Retrive a given event from the Events collection.
        String error = "Error: could not find requested event!";
        String s = "";
        System.out.println("Retrieve some events: ");
        Event a = events.find("Activity1"); 
        if(a != null)   
            s = a.toString();
        else s = error;
        System.out.println("retrieve Activity1: " + s );
        s = "";
        a = events.find("Travel1");
        if(a != null)
            s = a.toString();
        else s = error;
        System.out.println("retrieve Travel1: " + s);
        s = "";
        a = events.find("Activity2");
        if(a != null)
            s = a.toString();
        else s = error;
        System.out.println("retrieve Activity2 (should fail): " + s + '\n');
        
        
        //Retrive a given provider from the Providers collection.
        error = "Error: could not find requested provider!";
        System.out.println("Retrieve some providers: ");
        Provider pr = providers.find("Provider1");
        if(pr != null)
            s = pr.toString();
        else s = error;
        System.out.println("retrieve Provider1: " + s);
        pr = providers.find("Provider3");
        if(pr != null)
            s = pr.toString();
        else s = error;
        System.out.println("retrieve Provider3: " + s);
        pr = providers.find("Provider4");
        if(pr != null)
            s = pr.toString();
        else s = error;
        System.out.println("retrieve Provider4 (should fail): " + s + '\n');
        
        
        //Test to see if two events are conflicting.
        error = "Error: the two events conflict!";
        String suc = "No conflict in event times!";
        System.out.println("Test to see if two events conflict: ");
        GregorianCalendar start1 = new GregorianCalendar(0,0,0,12,0);
        GregorianCalendar end1 = new GregorianCalendar(0,0,0, 14, 0);
        Event e1 = new Event("E1", start1, end1);
        GregorianCalendar start2 = new GregorianCalendar(0,0,0,10,0);
        GregorianCalendar end2 = new GregorianCalendar(0,0,0,12, 0);
        Event e2 = new Event("E2", start2, end2);
        boolean isConflict = e1.isConflicting(e2);
        System.out.println("Case 1: Event 1 ends before Event 2 starts: ");
        if(isConflict)
            s = error;
        else s = suc;
        System.out.println(s);
        
        end2 = new GregorianCalendar(0,0,0,13,0);
        e2 = new Event("E2", start2, end2);
        isConflict = e1.isConflicting(e2);
        System.out.println("Case 2: Event 1 starts before Event 2 but ends"
                + " after Event 2 starts (should fail):");
        if(isConflict)
            s = error;
        else s = suc;
        System.out.println(s);
        
        isConflict = e2.isConflicting(e1);
        System.out.println("Case 3: Event 1 starts before Event 2 ends and "
                + " ends after Event 2 ends (should fail):");
        if(isConflict)
            s = error;
        else s = suc;
        System.out.println(s);
        
        start2 = new GregorianCalendar(0,0,0,13,0);
        end2 = new GregorianCalendar(0,0,0,13,30);
        e2 = new Event("E2", start2, end2);
        isConflict = e1.isConflicting(e2);
        System.out.println("Case 4: Event 1 starts after Event 2 and ends "
                + " after Event 2 (should fail): ");
        if(isConflict)
            s = error;
        else s = suc;
        System.out.println(s);
        
        start2 = new GregorianCalendar(0,0,0,13,0);
        end2 = new GregorianCalendar(0,0,0,15,0);
        e2 = new Event("E2", start2, end2);
        isConflict = e1.isConflicting(e2);
        System.out.println("Case 5: Event 1 starts after Event 2 and ends "
                + "before Event 2 (should fail):");
        if(isConflict)
            s = error;
        else s = suc;
        System.out.println(s);
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        TestHarness tH = new TestHarness();
    }
}
