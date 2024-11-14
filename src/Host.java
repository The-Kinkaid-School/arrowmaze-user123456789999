import java.util.InputMismatchException;
import java.util.Scanner;

public class Host
{
    private final int GRID_SIZE = 15;
    private final String[] DIRECTION_STRINGS = {"←","↑","→","↓"};
//    private final String[] DIRECTION_STRINGS = {"<","^",">","v"}; // in case the arrow emojis don't show up on your
                                                                    //    system.
    private String[][] grid;
    private Scanner keyReader;
    public Host()
    {
        buildGrid();
        keyReader = new Scanner(System.in);
    }

    /**
     * the game loop of the program -- displays the grid of arrows, asks the user for a starting
     * point, displays the path that starts with that point, and repeats.
     */
    public void gameLoop()
    {
       while(true)
       {
           printGrid();
           KPoint p = askForStartPoint();
           KPoint[] path = getPathStartingAt(p);
           displayPath(path);
       }
    }

    /**
     * makes grid a GRID_SIZE x GRID_SIZE array of Strings, randomly filling it with arrows
     * from DIRECTION_STRINGS.
     */
    private void buildGrid()
    {
        // TODO #0 - we need to write this method!
    }

    /**
     * displays the grid of arrows, with numbered indices for row and column.
     */
    private void printGrid()
    {
        // draw the row with tens digits for column numbers
        System.out.print(" \t");
        for (int c=0; c<GRID_SIZE; c++)
            if (c < 10)
                System.out.print("  ");
            else
                System.out.print(c/10+" ");
        System.out.println();
        // draw the row with ones digits for column numbers
        System.out.print(" \t");
        for (int c=0; c<GRID_SIZE; c++)
            System.out.print(c%10+" ");
        System.out.println("\n");

        // draw the grid. include the row number and a tab at the start of each line.
        // TODO # 1 - we need to write a loop (or two) to do this.
    }

    /**
     * requests a row and column from the user.
     * @return a KPoint (row, column) given by the user.
     */
    public KPoint askForStartPoint()
    {
        boolean goodRow = false;
        boolean goodCol = false;
        int r = -1;
        int c = -1;

        while (! goodRow)
        {
            System.out.print("Enter a row number. ");
            try
            {
                r = keyReader.nextInt();
                if (r >= 0 && r < GRID_SIZE)
                    goodRow = true;
                else
                    System.out.println(r + " is out of range.");
            } catch (InputMismatchException imExc)
            {
                System.out.println("That wasn't a number. Please try again.");
                String dummy = keyReader.nextLine();
            }
        }
        while (!goodCol)
        {
            System.out.print("Enter a column number. ");
            try
            {
                c = keyReader.nextInt();
                if (c >= 0 && c < GRID_SIZE)
                    goodCol = true;
                else
                    System.out.println(c + " is out of range.");
            } catch (InputMismatchException imExc)
            {
                System.out.println("That wasn't a number. Please try again.");
                String dummy = keyReader.nextLine();
            }
        }
        return new KPoint(r, c);
    }

    /**
     * Creates a list of KPoints, starting with the startPoint, where the arrow at each KPoint points to the next
     * KPoint, or to null. All KPoints after the first null will also be null.
     * @param startPoint a KPoint within [0, GRID_SIZE) x [0, GRID_SIZE)
     * @return an array of KPoints with one or more KPoints, followed by null values.
     */
    public KPoint[] getPathStartingAt(KPoint startPoint)
    {
        KPoint p = startPoint;
        KPoint[] result = new KPoint[GRID_SIZE*GRID_SIZE]; // the maximum possible path, starts with all nulls.
        int pathLength = 0;
        while (true)
        {
            if (p == null)
                throw new RuntimeException("Something has gone wrong. p shouldn't be null.");

            // add the latest point to the path and increment length
            result[pathLength] = p;
            pathLength++;

            // find the arrow at the latest point
            String arrow = " "; // TODO #2 - we need to replace this with the value of grid at p.

            // find the KPoint that arrow points to... if it is out of bounds, break.
            KPoint p2 = p; // for now... we should replace this with the KPoint p is pointing to in the "if" statements
                           //            ahead.
            // Note: I'm intentionally not using a switch/case statement here because I want to be able to break out of
            //        the loop with a "break" statement, and that would break out of just the switch.
            if (arrow.equals(DIRECTION_STRINGS[0])) // left
            {
                // TODO #3a - check whether p is on the left edge; break if so.
                // TODO #3b - set p2 to be the KPoint to the left of p.
            }
            else if (arrow.equals(DIRECTION_STRINGS[1])) // up
            {
                // TODO #4a - check whether p is on the top edge; break if so.
                // TODO #4b - set p2 to be the KPoint to the north of p.
            }
            else if (arrow.equals(DIRECTION_STRINGS[2])) // right
            {
                // TODO #5a - check whether p is on the right edge; break if so.
                // TODO #5b - set p2 to be the KPoint to the right of p.
            }
            if (arrow.equals(DIRECTION_STRINGS[3])) // down
            {
                // TODO #6a - check whether p is on the bottom edge; break if so.
                // TODO #6b - set p2 to be the KPoint to the south of p.
            }

            boolean foundMatch = false;
            // check whether that new KPoint is already in the list. If so, set foundMatch to true.
            for (int i=0; i<pathLength; i++)
            {
                if (result[i] == null)
                    break;
                if (p2.equals(result[i]))
                {
                    foundMatch = true;
                    break;
                }
            }


            // (if so, break out of the loop.)
            if (foundMatch)
                break;

            // set the latest point to be the one we just found.
            p = p2;
        }
        return result;
    }

    /**
     * draws a similar grid to the printGrid, where all the arrows are replaced by dots, except for the ones on the
     * given path.
     * @param path - the array of KPoints where we should reveal the arrows, at least for the non-null entries.
     */
    public void displayPath(KPoint[] path)
    {
        // start with all dots
        String[][] output;
        // TODO #7 - set output to be GRID_SIZE x GRID_SIZE and all "." strings.

        // replace any points in path with the arrows from grid (and count steps)
        int numSteps = 0;
        for (KPoint p : path)
        {
            if (p == null)
                break;
            // TODO #8 - replace the "." in output at p with the arrow in grid at that same location.
            numSteps++;
        }

        // print out this grid.
        // TODO #9 - print this output grid out.

        System.out.println("Path had "+numSteps+" steps.");
    }

}
