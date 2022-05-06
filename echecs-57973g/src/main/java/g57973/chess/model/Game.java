/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import g57973.chess.model.pieces.Bishop;
import g57973.chess.model.pieces.King;
import g57973.chess.model.pieces.Knight;
import g57973.chess.model.pieces.Pawn;
import g57973.chess.model.pieces.Piece;
import g57973.chess.model.pieces.Queen;
import g57973.chess.model.pieces.Rook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g57973
 */
public class Game implements Model {
//JAVADOC DANS LA CLASSE MODEL

    protected final Board board;
    private final Player WHITE;
    private final Player BLACK;
    private Player currentPlayer;
    private final King whiteKing;
    private final King blackKing;
    private GameState state;

    /**
     * represent the game and all these components
     */
    public Game() {
        this.board = new Board();
        this.WHITE = new Player(Color.WHITE);
        this.BLACK = new Player(Color.BLACK);
        this.whiteKing = new King(Color.WHITE);
        this.blackKing = new King(Color.BLACK);
    }

    /**
     * create the array and initialize all the pieces on it
     */
    @Override
    public void start() {
        this.state = GameState.PLAY;

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
        board.setPiece(new Rook(Color.WHITE), new Position(0, 0));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 7));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 1));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 6));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 5));
        board.setPiece(new Queen(Color.WHITE), new Position(0, 3));
        board.setPiece(whiteKing, new Position(0, 4));

        board.setPiece(new Rook(Color.BLACK), new Position(7, 0));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 7));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 1));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 6));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 5));
        board.setPiece(new Queen(Color.BLACK), new Position(7, 3));
        board.setPiece(blackKing, new Position(7, 4));
    }

    /**
     * @return actual state of the game
     */
    @Override
    public GameState getState() {
        return this.state;
    }

    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("cette position n'est pas contenur dans le tableau");
        } else {
            return this.board.getPiece(pos);
        }
    }

    /**
     * 
     * @return the current player
     */
    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * 
     * @return the opposite player
     */
    @Override
    public Player getOppositePlayer() {
        return currentPlayer == WHITE ? BLACK : WHITE;
    }

    /**
     * Check if a position is occupied by the current player
     * @param pos
     * @return 
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return (!board.isFree(pos)) && (board.getPiece(pos).getColor() == currentPlayer.getColor());
    }

    
    /**
     * 
     * @param oldPos
     * @param newPos 
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        Piece cettePiece = board.getPiece(oldPos);
        Piece king;
        Piece oppositeKing;
        List<Position> myCaptures =new  ArrayList<>();
        if (currentPlayer.getColor() == Color.WHITE) {
            king = whiteKing;
            oppositeKing = blackKing;
        } else {
            king = blackKing;
            oppositeKing = whiteKing;
        }
        myCaptures = (king.getCapturePositions(board.getPiecePosition(king), board));

        if ((!board.contains(oldPos)) || (!board.contains(newPos))) {
            throw new IllegalArgumentException("Une des positions données n'est pas dans le plateau");
        }
        if ((board.isFree(oldPos))) {
            throw new IllegalArgumentException("Pas de pion à déplacer");
        }
        
        if (!(getPossibleMoves(oldPos).contains(newPos))) {
            throw new IllegalArgumentException("Vous ne pouvez pas vous déplacer à cette position !");
        }
        
        if (!(cettePiece.getColor() == currentPlayer.getColor())) {
            throw new IllegalArgumentException("Ce n'est pas votre pion !");
        }
        else if (isValidMove(oldPos, newPos)) {
            board.setPiece(cettePiece, newPos);
            board.dropPiece(oldPos);
        }

        if (king_in_check(oldPos,newPos)) {
            if (noValidMoves(getOppositePlayer())) {
                state = GameState.CHECK_MATE;
            } else {
                state = GameState.CHECK;
            }
        }
        if (noValidMoves(getOppositePlayer())) {
            state = GameState.STALE_MATE;
        } else {
            state = GameState.PLAY;
        }
        this.currentPlayer = getOppositePlayer();
    }
    
/**
 * Checks if a player can still make a VALID move
 * @param player
 * @return false if he can , true otherwise
 */
    private boolean noValidMoves(Player player) {

        for (Position pos : board.getPositionOccupiedBy(player)) {
            for (Position move : getPossibleMoves(pos)) {
                if (isValidMove(pos, move)) {
                    return false;
                }
            }
        }
        return true;
    }
//    @Override
//    public boolean isGameOver() {
//        /**
//         * boolean gameOver = false;
//         *
//         * if (board.getPositionOccupiedBy(getCurrentPlayer()).isEmpty()) {
//         * gameOver = true; }
//         *
//         * for (Position pos : board.getPositionOccupiedBy(getCurrentPlayer()))
//         * { if (getPossibleMoves(pos).isEmpty()) { gameOver = true; } } return
//         * gameOver;
//         */
//        return false;
//    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

    /**
     * Create a list of all moves where the piece can capture another
     * @param player
     * @return List with all these positions
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capturePositions = new ArrayList<>();

        board.getPositionOccupiedBy(player).forEach(pos -> {
            getPossibleMoves(pos).forEach(position -> {
                capturePositions.add(position);
            });
        });
        return capturePositions;
    }

    /**
     * Checks if a move would put the current king in check and
     * other conditions that verify the validity of a move
     * @param oldPos
     * @param newPos
     * @return true if the move is valid, false otherwise
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        boolean validMove;
        

        if (!board.contains(oldPos)) {
            throw new IllegalArgumentException("ancienne position non contenue");
        }
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("ancienne position vide");
        }
        if (!board.contains(newPos)) {
            throw new IllegalArgumentException("nouvelle position non contenue");
        }

        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("nouvelle position pas possible pour l'ancienne position");
        }
        
        if(king_in_check(oldPos,newPos)){
            throw new IllegalArgumentException("Vous mettrez votre roi en échec, réessayez :");
        }
        
        else {
            validMove = true;
        }
        return validMove;
    }
    
    /**
     * Checks if a move would put the current king in check
     * @param oldPos
     * @param newPos
     * @return true if my king would be in check, false otherwise
     */
    private boolean king_in_check(Position oldPos,Position newPos){
        boolean invalidMove = false; 
        Piece recupold = this.getPiece(oldPos);
        Piece recupnew = this.getPiece(newPos);

        board.setPiece(recupold, newPos);
        board.dropPiece(oldPos);
        
        Piece king;
        if (currentPlayer.getColor() == Color.WHITE) {
            king = whiteKing;
        } else {
            king = blackKing;
        }

        if(getCapturePositions(getOppositePlayer()).contains(board.getPiecePosition(king))){
            invalidMove = true;
        }
        
        board.setPiece(recupold,oldPos);
        board.setPiece(recupnew,newPos);

        
        return invalidMove;
    }
    
}
