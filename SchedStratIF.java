/**
 * SchedStratIF.java
 *
 *  This interface is designed to mandate a scheduling
 * method, that is to be implemented in the 3 seperate
 * strategy classes.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

interface SchedStratIF
{
  
  /**
   * Method to implement the scheduling logic
   * specific to each class type
   *  Return type: int
   *   returns 0 on success, non 0 on failure
   */
  public abstract int sched( Tour t );

}
