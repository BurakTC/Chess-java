/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import java.util.List;

/**
 *
 * @author g57973
 */
public class Game implements Model {
    
    private Board board;
    private Player WHITE;
    private Player BLACK;
    private Player currentPlayer;

    public Game(Board board, Player WHITE, Player BLACK) {
        this.board = board;
        this.WHITE = WHITE;
        this.BLACK = BLACK;
    }

    
    
    
    @Override
    public void start() {
    }

    @Override
    public Piece getPiece(Position pos) {
        return null;
    }

    @Override
    public Player getCurrentPlayer() {
        return null;
    }

    @Override
    public Player getOppositePlayer() {
        return null;
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return false;
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        return null;
    }

}
