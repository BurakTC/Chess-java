/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 * This class represents one of the 64 squares on the game board
 *
 * @author g57973
 */
public class Square {

    /**
     * the piece contained on the game square, 
     * =null if the square is empty
     */
    private Piece piece;

    /**
     * initialize an empty square
     */
    public Square() {
        this.piece = null;
        
    }

    /**
     * 
     * @return the contained pawn
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * put a piece in a square
     * @param piece 
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * 
     * @return true if a square is empty , false otherwise
     */
    public boolean isFree() {
        return this.piece == null ;
    }

}
