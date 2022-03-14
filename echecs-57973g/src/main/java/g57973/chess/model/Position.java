/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 * Représente une position exacte dans un tableau de jeu.
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

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
    
    public Position next(Direction dir){
        return new Position(this.row + dir.getDeltaRow() , this.column + dir.getDeltaColumn());
    }
    
    

}
