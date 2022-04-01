/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g57973
 */
public class Game implements Model {

    private Board board;
    private final Player WHITE;
    private final Player BLACK;
    private Player currentPlayer;

    public Game(Board board, Player WHITE, Player BLACK) {
        this.board = board;
        this.WHITE = WHITE;
        this.BLACK = BLACK;
    }

    @Override
    public void start() {
        currentPlayer = this.WHITE;
        board = new Board();

    }

    @Override
    public Piece getPiece(Position pos) {
        return this.getPiece(pos);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public Player getOppositePlayer() {
        return currentPlayer == WHITE ? BLACK : WHITE;
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return (!board.isFree(pos)) && (board.getPiece(pos).getColor() == currentPlayer.getColor());
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if ((!board.contains(oldPos)) || (!board.contains(newPos)) || (!board.isFree(oldPos))
                || board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le plateau");
        } else {
            Piece cettePiece = board.getPiece(oldPos);
            board.setPiece(cettePiece, newPos);
            board.dropPiece(oldPos);
        }
        if (!isGameOver()) {
            getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        boolean gameOver =false;
        Position pos;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getPositionOccupiedBy(BLACK).){
                    gameOver = true;
                }
                    
            }
        }
            
        
    
    
    }
        /**
         * boolean gameOver = false;
        List<Position> positions = new ArrayList();
        for (int i = 0; i <= positions.size(); i++) {
            if (getPiece(positions.get(i)).getPossibleMoves(positions.get(i), board).isEmpty()) {
                gameOver = true;
            }
        }

        return gameOver;*/
    

    
    
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

}
