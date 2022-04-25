/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import g57973.chess.model.pieces.Pawn;
import g57973.chess.model.pieces.Piece;
import java.util.List;

/**
 *
 * @author g57973
 */
public class Game implements Model {
//JAVADOC DANS LA CLASSE MODEL

    private final Board board;
    private final Player WHITE;
    private final Player BLACK;
    private Player currentPlayer;
    
    public Game() {
        this.board = new Board();
        this.WHITE = new Player(Color.WHITE);
        this.BLACK = new Player(Color.BLACK);
    }
    
    @Override
    public void start() {
        this.currentPlayer = WHITE;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == board.getInitialPawnRow(Color.BLACK)) {
                    board.setPiece(new Pawn(Color.BLACK), new Position(i, j));
                }
                if (i == board.getInitialPawnRow(Color.WHITE)) {
                    board.setPiece(new Pawn(Color.WHITE), new Position(i, j));
                    
                }
            }
        }
    }
    
    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("cette position n'est pas contenur dans le tableau");
        } else {
            return this.board.getPiece(pos);
            
        }
    }
    
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    @Override
    public Player getOppositePlayer() {
        return currentPlayer == WHITE ? currentPlayer = BLACK : WHITE;
    }
    
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return (!board.isFree(pos)) && (board.getPiece(pos).getColor() == currentPlayer.getColor());
    }
    
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        Piece cettePiece = board.getPiece(oldPos);

        if ((!board.contains(oldPos)) || (!board.contains(newPos))) {
            throw new IllegalArgumentException("Une des positions données n'est pas dans le plateau");
        }
        if ((board.isFree(oldPos))) {
            throw new IllegalArgumentException("Pas de pion à déplacer");
        }
        if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("Vous ne pouvez pas vous déplacer à cette position !");
        }
        if (!(cettePiece.getColor() == currentPlayer.getColor())) {
            throw new IllegalArgumentException("Ce n'est pas votre pion !");
        } else {
            board.setPiece(cettePiece, newPos);
            board.dropPiece(oldPos);
        }
        if(!isGameOver()){
            this.currentPlayer = getOppositePlayer();
        }
            
        
        
    }
    
    @Override
    public boolean isGameOver() {
        boolean gameOver = false;
        
        if (board.getPositionOccupiedBy(getCurrentPlayer()).isEmpty()) {
            gameOver = true;
        }
        
        for (Position pos : board.getPositionOccupiedBy(getCurrentPlayer())) {
            if (getPossibleMoves(pos).isEmpty()) {
                gameOver = true;
                
            }
            
        }
        
        return gameOver;
    }
    
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }
    
}
