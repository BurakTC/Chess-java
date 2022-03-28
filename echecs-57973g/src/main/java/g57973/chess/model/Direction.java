
package g57973.chess.model;

/**
 * These directions will allow a pawn to move around our game board.
 * @author Burak
 */
public enum Direction {
    NW(1,-1),N(1,0),NE(1,1),W(0,-1),E(0,1),SW(-1,-1),S(-1,0),SE(-1,1);
    
    private final int deltaRow;
    private final int deltaColumn;

    /**
     * 
     * @param deltaRow
     * @param deltaColumn 
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Getter for the line of the new direction
     * @return 
     */
    public int getDeltaRow() {
        return this.deltaRow;
    }

    /**
     * getter for the row of the new direction
     * @return 
     */
    public int getDeltaColumn() {
        return this.deltaColumn;
    }
    

    
    
   
}
