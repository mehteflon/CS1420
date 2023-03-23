package lab10;

/**
 * A grid object represents the cell grid of a life simulation.
 * The grid is a 2D array of cells.  The grid object keeps track
 * of the state of each cell (alive, dead), and allows the user
 * to make one step in the life simulation.
 * 
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 * 
 * @author Peter Jensen and Will Graham
 * @version 3/21/2023
 */
public class Grid
{
    // Instance variables here.
    private boolean[][] grid;
    private int width;
    private int height;

    /**
     * Constructor - creates an empty grid of the
     * specified dimensions.
     * 
     * @param width The width of the new grid
     * @param height The height of the new grid
     */
    public Grid (int height, int width)
    {
        this.grid = new boolean[height][width];
        this.width = width;
        this.height = height;

        for (int i = 0; i < width; i++) {
            for (int k = 0; k < height; k++) {
                grid[k][i] = false;
            }
        }
    }

    /**
     * Returns true if the specified cell in the grid
     * is alive, false otherwise.  If the coordinates
     * are illegal (outside the grid), false is returned.
     *
     * @param row  a row number
     * @param column a column number
     * @return true iff that cell is alive
     */
    public boolean isAlive (int row, int column)
    {
        if (row >= 0 && row < this.height && column >= 0 && column < this.width && (this.grid[row][column]) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /** 
     * Returns the width of the grid.
     * 
     * @return the width of this grid
     */
    public int getWidth ()
    {
    	return this.width;  // Stub - replace
    }

    /** 
     * Returns the height of the grid.
     * 
     * @return the height of this grid
     */
    public int getHeight ()
    {
    	return this.height;  // Stub - replace
    }
    
    /**
     * Sets the state of the specified cell in the
     * grid.
     * 
     * @param row a row number
     * @param column a column number
     * @param isAlive true if the grid cell should be alive
     */
    public void setCellState(int row, int column, boolean isAlive)
    {
        if (isAlive == true) {
            this.grid[row][column] = true;
        } else if (isAlive == false) {
            this.grid[row][column] = false;
        }
    }
    
 
    /**
     * Clears the grid, all cells marked as dead.
     */
    public void clear ()
    {
        for (int i = 0; i < this.width; i++) {
            for (int k = 0; k < this.height; k++) {
                this.grid[k][i] = false;
            }
        }
    }
    
    /**
     * Performs one 'life' step using the standard rules
     * of life:
     * 
     * Any live cell with fewer than two neighbors dies, as if by loneliness.
     * Any live cell with more than three neighbors dies, as if by overcrowding.
     * Any live cell with two or three neighbors lives, unchanged, to the next generation.
     * Any dead cell with exactly three neighbors comes to life.
     * 
     * Care must be taken to make sure the next generation is kept separate from the 
     * current generation.
     */
    public void stepOneGeneration ()
    {
    	// Create a spare grid
    	boolean[][] spareGrid = new boolean[this.height][this.width];

    	// Loop through each grid location
        for (int i = 0; i < this.height; i++) {
            for (int k = 0; k < this.width; k++) {
                int neighborCount = countNeighbors(i, k);

                if (isAlive(i, k)) {
                    if (neighborCount == 0 || neighborCount == 1) {
                        spareGrid[i][k] = false;
                    } else if (neighborCount == 2 || neighborCount == 3) {
                        spareGrid[i][k] = true;
                    } else if (neighborCount >= 4) {
                        spareGrid[i][k] = false;
                    }
                } else if ((isAlive(i, k)) == false) {
                    if (neighborCount == 3) {
                        spareGrid[i][k] = true;
                    } else if (neighborCount == 0 || neighborCount == 1 || neighborCount == 2 || neighborCount >= 4) {
                        spareGrid[i][k] = false;
                    }
                }
            }
        }
        this.grid = spareGrid;
    }

    public int countNeighbors(int x, int y) {
        int aliveNeighbors = 0;

        int[] rowNeighbors = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNeighbors = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = x + rowNeighbors[i];
            int newColumn = y + colNeighbors[i];

            if (newRow >= 0 && newRow < height && newColumn >= 0 && newColumn < width) {
                if (grid[newRow][newColumn]) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }
}
