/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import g57973.chess.model.pieces.King;
import g57973.chess.model.pieces.Pawn;
import g57973.chess.model.pieces.Piece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Burak
 */
public class GameTest {
   
    public GameTest() {
    }
    
    Board board;
    Game game;
    
    @BeforeEach
    public void setUp() {
        game = new Game();
    }
    
    
    @Test //returns the position of the king alone
    public void BlackKing_LIBRE() {
        
        Piece roi = new King(Color.BLACK);
        Position instance = new Position(3,2);
        
        game.board.setPiece(roi, instance);
        
        Position expResult = game.getPiecePosition(roi);
        
        //assertEquals(instance, expResult);
        assertEquals(instance.getRow(),expResult.getRow());
        assertEquals(instance.getColumn(),expResult.getColumn());
    }
    @Test //returns the position of the king with other pieces
    public void BlackKing_avec_pieces() {
        
        Piece inutile = new Pawn(Color.BLACK);
        Piece inutile2 = new King(Color.BLACK);
        
        Piece roi = new King(Color.BLACK);
        
        Position instance = new Position(3,2);
        Position pos1= new Position(2,3);
        Position pos2 = new Position(6,7);
        
        game.board.setPiece(roi, instance);
        game.board.setPiece(inutile,pos1);
        game.board.setPiece(inutile2,pos2);
        
        Position expResult = game.getPiecePosition(roi);
        
        //assertEquals(instance, expResult);
        assertEquals(instance.getRow(),expResult.getRow());
        assertEquals(instance.getColumn(),expResult.getColumn());
    }
    
    
}
