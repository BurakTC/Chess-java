/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;
import java.util.List;
import java.util.ArrayList;

/**
 *Represents a pawn in the game
 * @author g57973
 */
public class Piece {
    /**
     * the only attribute of our pawn is its color
     */
    private final Color color;

    /**
     * constructor of our pawn
     * @param color 
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * 
     * @return the color of this pawn
     */
    public Color getColor() {
        return color;
    }

    
public List<Position> getPossibleMoves(Position position, Board board){
    return null; //A FAIRE
}
    
}
