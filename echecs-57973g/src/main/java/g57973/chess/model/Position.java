/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 * Represents a position in the game, 
 * contains values ​​for a row and a column.
 *
 * @author g57973
 */
public class Position {

    //Attributs 
    private int row;
    private int column;

    public Position(int row, int cloumn) {
        this.row = row;
        this.column = cloumn;
    }

    /**
     * 
     * @return the current position row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * 
     * @return the current position column
     */
    public int getColumn() {
        return this.column;
    }
    
    /**
     * 
     * @param dir

     * @returns the new position after moving in a given direction
     */
    public Position next(Direction dir){
        return new Position(this.row + dir.getDeltaRow() , this.column + dir.getDeltaColumn());
    }
    
    

}
