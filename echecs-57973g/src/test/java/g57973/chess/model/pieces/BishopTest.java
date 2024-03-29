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
public class BishopTest {

    public BishopTest() {
    }

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMoves_Bishop_LIBRE() {
        Position position = new Position(3, 4);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(0, 7),
                new Position(1, 6),
                new Position(2, 5),
                new Position(4, 3),
                new Position(5, 2),
                new Position(6, 1),
                new Position(7, 0),
                new Position(0, 1),
                new Position(1, 2),
                new Position(2, 3),
                new Position(4, 5),
                new Position(5, 6),
                new Position(6, 7)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMoves_Bishop_COIN() {
        Position position = new Position(0, 0);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 1),
                new Position(2, 2),
                new Position(3, 3),
                new Position(4, 4),
                new Position(5, 5),
                new Position(6, 6),
                new Position(7, 7)
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishop_PAWN_ENNEMI() {
        Position position = new Position(3, 4);
        Position posennemi = new Position(5, 6);
        Position posennemi2 = new Position(4, 3);

        Piece ennemi = new Pawn(Color.BLACK);
        Piece ennemi2 = new Pawn(Color.BLACK);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(ennemi, posennemi);
        board.setPiece(ennemi2, posennemi2);
        

        List<Position> expected = List.of(
                new Position(0,1),
                new Position(1,2),
                new Position(2,3),
                new Position(4,5),
                new Position(5,6),
                
                new Position(4,3),
                new Position(0,7),
                new Position(1,6),
                new Position(2,5)
                
        );
        List<Position> positions = piece.getPossibleMoves(position, board);
        assertEqualsIgnoringOrder(expected, positions);
    }

    @Test
    public void testGetPossibleMovesBishop_PAW_NAMI() {
        Position position = new Position(3, 4);
        Position posami = new Position(5, 6);
        Position posami2 = new Position(4, 3);

        Piece ami = new Pawn(Color.WHITE);
        Piece ami2 = new Pawn(Color.WHITE);
        Piece piece = new Bishop(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(ami,posami);
        board.setPiece(ami2, posami2);
        

        List<Position> expected = List.of(
                new Position(0,1),
                new Position(1,2),
                new Position(2,3),
                new Position(4,5),
                //new Position(5,6), Ne peut pas prendre la position de l'allié
                
                //new Position(4,3), IDEM
                new Position(0,7),
                new Position(1,6),
                new Position(2,5)
                
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
