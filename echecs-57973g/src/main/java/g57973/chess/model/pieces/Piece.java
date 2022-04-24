/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model.pieces;

import g57973.chess.model.Board;
import g57973.chess.model.Color;
import g57973.chess.model.Direction;
import g57973.chess.model.Position;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a pawn in the game
 *
 * @author g57973
 */
public abstract class Piece {

    /**
     * the only attribute of our pawn is its color
     */
    final Color color;

    /**
     * constructor of our pawn
     *
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

    abstract List<Position> getPossibleMoves(Position position, Board board);

    /**
     * List<Position> possibleMoves = new ArrayList<>();
     *
     * Position pos1; Position pos2; if (!board.contains(position)) { throw new
     * IllegalArgumentException("La position donnée n'est pas sur le plateau");
     * } if (!board.isFree(position)) {
     *
     * //PION BLANC if (board.getPiece(position).color == Color.WHITE) { pos1 =
     * position.next(Direction.N); pos2 = pos1.next(Direction.N);
     *
     * if (board.isFree(pos1)) { possibleMoves.add(pos1); } if
     * ((position.getRow() == board.getInitialPawnRow(Color.WHITE)) &&
     * (board.isFree(pos2))) { possibleMoves.add(pos2); } } //PION NOIR if
     * (board.getPiece(position).color == Color.BLACK) { pos1 =
     * position.next(Direction.S); pos2 = pos1.next(Direction.S);
     *
     * if (board.isFree(pos1)) { possibleMoves.add(pos1); } if
     * ((position.getRow() == board.getInitialPawnRow(Color.BLACK)) &&
     * (board.isFree(pos2))) { possibleMoves.add(pos2); }
     *
     * }
     *
     * }
     *
     * return possibleMoves;
     * @param position
     * @param board
     * @return 
     */

    public List<Position> getCapturePositions(Position position, Board board){
        return getPossibleMoves(position, board);
    }

}
