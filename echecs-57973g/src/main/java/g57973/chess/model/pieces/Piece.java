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

    public abstract List<Position> getPossibleMoves(Position position, Board board);

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
     *
     * @param position
     * @param board
     * @return
     */
    public List<Position> getCapturePositions(Position position, Board board) {
        return getPossibleMoves(position, board);
    }

    protected List<Position> getPossibleDiag(Position position, Board board) {
        Position nw = position.next(Direction.NW);
        Position ne = position.next(Direction.NE);
        Position se = position.next(Direction.SE);
        Position sw = position.next(Direction.SW);

        List<Position> possibleDiag = new ArrayList<>();

        while (board.contains(nw) && board.isFree(nw)) {
            possibleDiag.add(nw);
            nw = new Position(nw.getRow() + 1, nw.getColumn() - 1);
        }
        while (board.contains(ne) && board.isFree(ne)) {
            possibleDiag.add(ne);
            ne = new Position(ne.getRow() + 1, ne.getColumn() + 1);
        }
        while (board.contains(se) && board.isFree(se)) {
            possibleDiag.add(se);
            se = new Position(se.getRow() - 1, se.getColumn() + 1);
        }
        while (board.contains(sw) && board.isFree(sw)) {
            possibleDiag.add(sw);
            sw = new Position(sw.getRow() - 1, sw.getColumn() - 1);
        }

        return possibleDiag;
    }

    protected List<Position> getPossibleHorizon(Position position, Board board) {
        List<Position> possibleHorizon = new ArrayList<>();

        Position n = position.next(Direction.N);
        Position w = position.next(Direction.W);
        Position s = position.next(Direction.S);
        Position e = position.next(Direction.E);

        while (board.contains(n) && board.isFree(n)) {
            possibleHorizon.add(n);
            n = new Position(n.getRow() + 1, n.getColumn());
        }
        while (board.contains(w) && board.isFree(w)) {
            possibleHorizon.add(w);
            w = new Position(w.getRow(), w.getColumn() - 1);
        }
        while (board.contains(s) && board.isFree(s)) {
            possibleHorizon.add(s);
            s = new Position(s.getRow() - 1, s.getColumn());
        }
        while (board.contains(e) && board.isFree(e)) {
            possibleHorizon.add(e);
            e = new Position(e.getRow(), e.getColumn() - 1);
        }
        
        return possibleHorizon;
    }

}
