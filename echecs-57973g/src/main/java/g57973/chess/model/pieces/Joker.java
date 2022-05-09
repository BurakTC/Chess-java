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
 * @author g57973
 */
public class Joker extends Piece {

    public Joker(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        
        Position posne = position.next(Direction.NE);
        Position possw = position.next(Direction.SW);
        Position posnw = position.next(Direction.NW);
        Position posse = position.next(Direction.SE);
        
        Position diagne = null;
        Position diagsw = null;
        Position diagse = null;
        Position diagnw = null;

        //JOKER BLANC
        if (board.contains(position)&&board.getPiece(position).getColor() == Color.WHITE) {
            while(board.contains(posne)&&board.isFree(posne)|| board.getPiece(posne)==(new Knight(Color.BLACK)) ) {
                diagne = posne;
                posne = posne.next(Direction.NE);
            }
            while (board.contains(possw)&&board.isFree(possw)|| board.getPiece(posne)==(new Knight(Color.BLACK))) {
                diagsw = possw;
                possw = possw.next(Direction.SW);
            }
            possibleMoves.add(diagsw);
            possibleMoves.add(diagne);
            possibleMoves.add(position);
        }

        //JOKER NOIR    
        if (board.contains(position)&&board.getPiece(position).getColor() == Color.BLACK ) {
            while (board.contains(posnw)&&board.isFree(posnw)||board.getPiece(posne)==(new Knight(Color.WHITE))) {
                diagnw = posnw;
                posnw = posnw.next(Direction.NW);
            }
            
            while (board.contains(possw)&&board.isFree(possw)|| board.getPiece(posne)==(new Knight(Color.WHITE))) {
                diagse = posse;
                posse = posse.next(Direction.SE);
            }
            
            possibleMoves.add(diagnw);
            possibleMoves.add(diagse);
            possibleMoves.add(position);
        }
        return possibleMoves;
    }
    

    @Override
    public String toString() {
        if (this.color == Color.WHITE) {
            return "  JB | ";
        } else {
            return "  JN | ";

        }

    }
}
