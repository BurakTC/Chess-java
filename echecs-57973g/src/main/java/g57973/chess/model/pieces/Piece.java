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

   
    public List<Position> getCapturePositions(Position position, Board board) {
        return getPossibleMoves(position, board);
    }

    protected List<Position> getPossibleDiag(Position position, Board board) {
        Position nw = position.next(Direction.NW);
        Position ne = position.next(Direction.NE);
        Position se = position.next(Direction.SE);
        Position sw = position.next(Direction.SW);
      
        List<Position> possibleDiag = new ArrayList<>();
        
       while (board.contains(nw)&&board.isFree(nw)) {
            possibleDiag.add(nw);
            nw = nw.next(Direction.NW);
        }
        if(board.contains(nw)&&board.containsOppositeColor(nw, this.color)){
            possibleDiag.add(nw);
        }
        
        while (board.contains(ne)&&board.isFree(ne)) {
            possibleDiag.add(ne);
            ne = ne.next(Direction.NE);
        }
        if(board.contains(ne)&&board.containsOppositeColor(ne, this.color)){
            possibleDiag.add(ne);
        }
        
        while (board.contains(se)&&board.isFree(se)) {
            possibleDiag.add(se);
            se = se.next(Direction.SE);
        }
        if(board.contains(se)&&board.containsOppositeColor(se, this.color)){
            possibleDiag.add(se);
        }
        
        while (board.contains(sw)&&board.isFree(sw)) {
            possibleDiag.add(sw);
            sw = sw.next(Direction.SW);
        }
        if(board.contains(sw)&&board.containsOppositeColor(sw, this.color)){
            possibleDiag.add(sw);
        }
        return possibleDiag;
    }

    protected List<Position> getPossibleHorizon(Position position, Board board) {
        List<Position> possibleHorizon = new ArrayList<>();
        
        Position n = position.next(Direction.N);
        Position w = position.next(Direction.W);
        Position s = position.next(Direction.S);
        Position e = position.next(Direction.E);
        
        while (board.contains(n)&&board.isFree(n)) {
            possibleHorizon.add(n);
            n = n.next(Direction.N);
        }
        if(board.contains(n)&&board.containsOppositeColor(n, this.color)){
            possibleHorizon.add(n);
        }
        
        while (board.contains(w)&&board.isFree(w)) {
            possibleHorizon.add(w);
            w = w.next(Direction.W);
        }
        if(board.contains(w)&&board.containsOppositeColor(w, this.color)){
            possibleHorizon.add(w);
        }
        
        while (board.contains(s)&&board.isFree(s)) {
            possibleHorizon.add(s);
            s = s.next(Direction.S);
        }
        if(board.contains(s)&&board.containsOppositeColor(s, this.color)){
            possibleHorizon.add(s);
        }
        
        while (board.contains(e)&&board.isFree(e)) {
            possibleHorizon.add(e);
            e = e.next(Direction.E);
        }
        if(board.contains(e)&&board.containsOppositeColor(e, this.color)){
            possibleHorizon.add(e);
        }
       
        return possibleHorizon;
    }
}
