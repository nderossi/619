/**
 * a9.java
 *
 *  This class is designed to be the main driver
 * for the tour scheduling group program.  The
 * class sets up a Scanner object for the input
 * file and passes it off to the command processor.
 *
 * @author Nick DeRossi
 * Group:  Nick DeRossi, Tyler Janowski, Nick Grauel
 */

import java.io.*;
import java.util.*;

public class a9
{

  public static void main( String args[] )
  {
    Scanner s = null;
    if( args.length > 0 )
    {
      try
      {
        s = new Scanner( new File( args[ 0 ] ) );
      }
      catch( FileNotFoundException e )
      {
        System.err.println( "File Not Found!" );
        System.exit( -1 );
      }
    }
    else
      s = new Scanner( System.in );

    Commander co = new Commander( s );
    co.action();
  }

}
