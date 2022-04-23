/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import g57973.chess.model.pieces.Piece;
import java.util.List;
import java.util.ArrayList;

/**
 * This is the game board
 *
 * @author g57973
 */
public class Board {

    /**
     * Initialise the game board , an 8x8 2d array
     */
    private final Square[][] squares;

    public Board() {

        this.squares = new Square[8][8];
        for (Square[] square : squares) {
            for (int j = 0; j < squares.length; j++) {
                square[j] = new Square();
            }
        }
    }

    /**
     *
     * @param pos
     * @return IllegalArgumentException if the given position is not in the game
     * board true otherwise
     */
    public boolean contains(Position pos) {
        int row = pos.getRow();
        int column = pos.getColumn();
        return (row >= 0 && row < 8 && column >= 0 && column < 8);
    }

    /**
     *
     * @param piece
     * @param pos puts a piece at the given position
     */
    public void setPiece(Piece piece, Position pos) {
        if (contains(pos)) {
            squares[pos.getRow()][pos.getColumn()].setPiece(piece);
        } else {
            throw new IllegalArgumentException("Le plateau ne contient pas la position donnée");
        }
    }
    //pour ajouter une piece dans une case precise 
    //squares[5][6].setPiece(new Piece(Color.WHITE));

    /**
     *
     * @param pos
     * @return the piece that is at a given position IllegalArgumentException if
     * the given position is not in the game board
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le plateau");
        } else {
            return squares[pos.getRow()][pos.getColumn()].getPiece();

        }
    }

    /**
     *
     * @param color
     * @return 6 for color BLACK, 1 for WHITE will be used to position the
     * pieces and know if they are in their initial position or not
     */
    public int getInitialPawnRow(Color color) {
        return color == Color.BLACK ? 6 : 1;
    }

    /**
     * removes the piece from the square at the given position
     *
     * @param pos IllegalArgumentException if the given position is not in the
     * game board true otherwise
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le plateau");
        } else {
            squares[pos.getRow()][pos.getColumn()].setPiece(null); // A VERIFIER 
        }
    }

    /**
     *
     * @param pos
     * @return true if the given position cell is free, false otherwise
     * IllegalArgumentException if the given position is not in the game board
     * true otherwise
     */
    public boolean isFree(Position pos) {
        if (contains(pos)) {
            return this.squares[pos.getRow()][pos.getColumn()].getPiece() == null;

        } else {
            throw new IllegalArgumentException("La position donnée n'est pas dans le plateau");
        }

    }

    /**
     *
     * @param pos
     * @param col
     * @return true if the given position square contains a piece of the
     * opposite color of the given piece, false otherwise.
     * IllegalArgumentException if the given position is not in the game board.
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le plateau");
        }

        Square var = squares[pos.getRow()][pos.getColumn()];
        return !var.isFree() && var.getPiece().getColor() == col.opposite();
    }

    /**
     *
     * @param player
     * @return the list of all the positions occupied by the given player
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> posList = new ArrayList<>();

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[i][j].getPiece() != null
                        && squares[i][j].getPiece().getColor() == player.getColor()) {
                    posList.add(new Position(i, j));
                }
            }
        }
        return posList;
    }
}
