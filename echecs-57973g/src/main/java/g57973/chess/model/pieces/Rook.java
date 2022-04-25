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
public class Rook extends Piece{

    public Rook(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList<>();
        
        for(Position pos : getPossibleHorizon(position,board)){
            possibleMoves.add(pos);
        }
        return possibleMoves;
    }
    
}
