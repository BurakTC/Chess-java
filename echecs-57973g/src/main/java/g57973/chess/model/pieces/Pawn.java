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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Burak
 */
public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {

        List<Position> possibleMoves = new ArrayList<>();

        Position pos1 = null;
        Position pos2 = null;

        if (!board.contains(position)) {
            throw new IllegalArgumentException("La position donnée n'est pas sur le plateau possiblemoves");
        }
        if (!board.isFree(position)) {

            //PION BLANC 
            if (board.getPiece(position).color == Color.WHITE) {
                pos1 = position.next(Direction.N);
                pos2 = pos1.next(Direction.N);

                if (board.isFree(pos1)) {
                    possibleMoves.add(pos1);
                }
                if ((position.getRow() == board.getInitialPawnRow(Color.WHITE))
                        && (board.isFree(pos2))) {
                    possibleMoves.add(pos2);
                }
            }

            //PION NOIR 
            if (board.getPiece(position).color == Color.BLACK) {
                pos1 = position.next(Direction.S);
                pos2 = pos1.next(Direction.S);

                if (board.isFree(pos1)) {
                    possibleMoves.add(pos1);
                }
                if ((position.getRow() == board.getInitialPawnRow(Color.BLACK))
                        && (board.isFree(pos2))) {
                    possibleMoves.add(pos2);
                }
            }
        }
        for(Position pos : getCapturePositions(position,board)){
            possibleMoves.add(pos);
        }
        return possibleMoves;
    }

    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        List<Position> capturePositions = new ArrayList<>();

        Position nw = position.next(Direction.NW);
        Position ne = position.next(Direction.NE);

        //PION BLANC
        if (board.getPiece(position).getColor() == Color.WHITE) {
            if (board.contains(nw) && (board.isFree(nw) || board.containsOppositeColor(nw, Color.WHITE))) {
                if (board.containsOppositeColor(nw, Color.WHITE)) {
                    capturePositions.add(new Position(nw.getRow(), nw.getColumn()));
                }
            }
        }
        if (board.getPiece(position).getColor() == Color.WHITE) {

            if (board.contains(ne) && (board.isFree(ne) || board.containsOppositeColor(ne, Color.WHITE))) {
                if (board.containsOppositeColor(ne, Color.WHITE)) {
                    capturePositions.add(new Position(ne.getRow(), ne.getColumn()));
                }
            }
        }

        //PION NOIR
        Position se = position.next(Direction.SE);
        Position sw = position.next(Direction.SW);

        if (board.getPiece(position).getColor() == Color.BLACK) {
            if (board.contains(se) && (board.isFree(se) || board.containsOppositeColor(se, Color.BLACK))) {
                if (board.containsOppositeColor(se, Color.BLACK)) {
                    capturePositions.add(new Position(se.getRow(), se.getColumn()));
                }
            }
        }
        if (board.getPiece(position).getColor() == Color.BLACK) {
            if (board.contains(sw) && (board.isFree(sw) || board.containsOppositeColor(sw, Color.BLACK))) {
                if (board.containsOppositeColor(sw, Color.BLACK)) {
                    capturePositions.add(new Position(sw.getRow(), sw.getColumn()));
                }
            }
        }
        return capturePositions;
    }
    
    
    
    @Override
    public String toString() {
        if (this.color == Color.WHITE) {
            return "  PB | ";
        } else {
            return "  PN | ";
        }
    }
}
