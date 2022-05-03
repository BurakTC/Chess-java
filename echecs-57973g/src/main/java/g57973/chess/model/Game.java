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

    public Game() {
        this.board = new Board();
        this.WHITE = new Player(Color.WHITE);
        this.BLACK = new Player(Color.BLACK);
        this.whiteKing = new King(Color.WHITE);
        this.blackKing = new King(Color.BLACK);
    }

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
        if (!isGameOver()) {
            this.currentPlayer = getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        /**
         * boolean gameOver = false;
         *
         * if (board.getPositionOccupiedBy(getCurrentPlayer()).isEmpty()) {
         * gameOver = true; }
         *
         * for (Position pos : board.getPositionOccupiedBy(getCurrentPlayer()))
         * { if (getPossibleMoves(pos).isEmpty()) { gameOver = true; } } return
         * gameOver;
         */
        return false;
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

    public Position getPiecePosition(Piece piece) {
        Position posPiece = null;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Position pos = new Position(i,j);
                if (!board.isFree(pos)&&board.getPiece(new Position(i, j)).equals(piece)) {
                    posPiece = new Position(i, j);
                }
            }
        }
        return posPiece;
    }

}
