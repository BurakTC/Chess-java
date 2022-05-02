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
public class PawnTest {
    
    Board board;
    
    public PawnTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesPawn1() {
        Position position = new Position(1,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    public void testGetPossibleMovesPawn2() {
        Position position = new Position(7,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
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

