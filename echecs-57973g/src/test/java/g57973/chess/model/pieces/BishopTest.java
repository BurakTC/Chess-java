/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model.pieces;

import g57973.chess.model.Board;
import g57973.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g57973
 */
public class BishopTest {
    
    public BishopTest() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPossibleMoves method, of class Bishop.
     */
    @Test
    public void testGetPossibleMoves() {
        System.out.println("getPossibleMoves");
        Position position = null;
        Board board = null;
        Bishop instance = null;
        List<Position> expResult = null;
        List<Position> result = instance.getPossibleMoves(position, board);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bishop.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bishop instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
