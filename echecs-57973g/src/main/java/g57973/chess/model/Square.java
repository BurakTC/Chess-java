/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 *
 * @author g57973
 */
public class Square {
    private Piece piece ;

    public Square() {
        this.piece = null;
    }
    

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public boolean isFree(){
        return this.piece == null;
    }
    
    
}
