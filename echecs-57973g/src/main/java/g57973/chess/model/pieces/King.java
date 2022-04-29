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
public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList();
        List<Position> testMoves = new ArrayList<>();
        testMoves.add(position.next(Direction.N));
        testMoves.add(position.next(Direction.NW));
        testMoves.add(position.next(Direction.W));
        testMoves.add(position.next(Direction.SW));
        testMoves.add(position.next(Direction.S));
        testMoves.add(position.next(Direction.SE));
        testMoves.add(position.next(Direction.E));
        testMoves.add(position.next(Direction.NE));
        
        testMoves.stream().filter(pos -> (board.contains(pos) && board.isFree(pos)||board.containsOppositeColor(pos, this.getColor()))).forEachOrdered(pos -> {
            possibleMoves.add(pos);
        });
        return possibleMoves;
    }
    @Override
    public String toString() {
        if(this.color==Color.WHITE){
            return "  *B | ";
        }else{
            return "  *N | ";
        } 
    }
}
