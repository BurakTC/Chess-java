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
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList<>();

        List<Position> possiblePos = new ArrayList<>();
        Position ne = position.next(Direction.NE);
        Position nw = position.next(Direction.NW);
        Position se = position.next(Direction.SE);
        Position sw = position.next(Direction.SW);

        possiblePos.add(new Position(ne.getRow() + 1, ne.getColumn()));
        possiblePos.add(new Position(ne.getRow(), ne.getColumn() + 1));

        possiblePos.add(new Position(nw.getRow() + 1, nw.getColumn()));
        possiblePos.add(new Position(nw.getRow(), nw.getColumn() - 1));
        
        possiblePos.add(new Position(sw.getRow()-1, sw.getColumn()));
        possiblePos.add(new Position(sw.getRow(), sw.getColumn() -1));
        
        possiblePos.add(new Position(se.getRow(), se.getColumn() + 1));
        possiblePos.add(new Position(se.getRow()-1, se.getColumn()));

        possiblePos.stream().filter(pos -> (board.contains(pos) && board.isFree(pos)||board.containsOppositeColor(pos, this.getColor()))).forEachOrdered(pos -> {
            possibleMoves.add(pos);
        });
        return possibleMoves;
        
        /*for(Position pos : possiblePos){
            if(board.contains(pos) && board.isFree(pos)||board.containsOppositeColor(pos, this.getColor())){
                possibleMoves.add(pos);
            }
        }
        return possibleMoves;*/
    }

}
