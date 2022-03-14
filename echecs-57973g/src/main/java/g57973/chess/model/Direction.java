/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 *Class who gives a direction for a movement.
 * @author g57973
 */


public enum Direction {
    NW(1,-1),N(1,0),NE(1,1),W(0,-1),E(0,1),SW(-1,-1),S(-1,0),SE(-1,1);
    
    private int deltaRow;
    private int deltaColumn;

    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    public int getDeltaRow() {
        return this.deltaRow;
    }

    public int getDeltaColumn() {
        return this.deltaColumn;
    }
    

    
    
   
}
