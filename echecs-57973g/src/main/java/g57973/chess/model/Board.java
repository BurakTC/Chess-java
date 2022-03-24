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
public class Board {
    
    private Square[][] squares;

    public Board() {
        
        this.squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                this.squares[i][j]= new Square() ;
            }
        }
        
    }
    
    
    
    
    public boolean contains(Position pos){
        int row = pos.getRow();
        int column = pos.getColumn();
        return (row>=0 && row<8 && column>=0 && column<8);
    }
    
    public void setPiece(Piece piece , Position pos){
        //pour ajouter une piece dans une case precise 
        //squares[5][6].setPiece(new Piece(Color.WHITE));
    }
    
    public Piece getPiece(Position pos){
        //A CONTINUER
        return null;
    }
    
}
