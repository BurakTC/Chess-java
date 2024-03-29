/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model.pieces;

import g57973.chess.model.Board;
import g57973.chess.model.Color;
import g57973.chess.model.Position;
import g57973.chess.model.pieces.King;
import g57973.chess.model.pieces.Pawn;
import g57973.chess.model.pieces.Piece;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srexhep
 */
public class KingTest {

    public KingTest() {
    }

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMoves_King_LIBRE() {
        Position position = new Position(3, 4);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(2, 4),
                new Position(2, 5),
                new Position(3, 3),
                new Position(4, 3),
                new Position(4, 4),
                new Position(4, 5),
                new Position(3, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves_King_COIN() {
        Position position = new Position(0, 0);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 1),
                new Position(1, 0),
                new Position(0, 1)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKing_PAWN_ENNEMI() {
        Position position = new Position(3, 4);
        Position posennemi = new Position(4, 4);
        Piece ennemi = new Pawn(Color.BLACK);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(ennemi, posennemi);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(2, 4),
                new Position(2, 5),
                new Position(3, 3),
                new Position(4, 3),
                new Position(4, 4),
                new Position(4, 5),
                new Position(3, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesKing_PAWN_AMI() {
        Position position = new Position(3, 4);
        Position posallié = new Position(4, 4);
        Piece allié = new Pawn(Color.WHITE);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(allié, posallié);

        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(2, 4),
                new Position(2, 5),
                new Position(3, 3),
                new Position(4, 3),
                new Position(4, 5),
                new Position(3, 5)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }


    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
}
