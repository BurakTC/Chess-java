/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model.pieces;

import g57973.chess.model.Board;
import g57973.chess.model.Color;
import g57973.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Burak
 */
public class Queen extends Piece {

    public Queen(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> getEveryMoves = new ArrayList<>();

        getPossibleDiag(position, board).forEach(pos -> {
            getEveryMoves.add(pos);
        });
        
        getPossibleHorizon(position, board).forEach(pos -> {
            getEveryMoves.add(pos);
        });

        return getEveryMoves;

    }
    @Override
    public String toString() {
        if(this.color==Color.WHITE){
            return "  #B | ";
        }else{
            return "  #N | ";
        } 
    }
}
