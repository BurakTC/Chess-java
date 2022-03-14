/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g57973
 */
public class PositionTest {
    

    
    /**
     * Test of next method, of class Position.
     */
    @Test
    public void testNext_cas1() {
        Direction dir = Direction.NE;
        Position instance = new Position(3,2);
        Position expResult = new Position(4,3);
        Position result = instance.next(dir);
        //assertEquals(expResult, result);
        assertEquals(result.getRow(),expResult.getRow());
        assertEquals(result.getColumn(),expResult.getColumn());
    }
    
     public void testNext_cas2() {
        Direction dir = Direction.SW;
        Position instance = new Position(3,2);
        Position expResult = new Position(2,1);
        Position result = instance.next(dir);
        //assertEquals(expResult, result);
        assertEquals(result.getRow(),expResult.getRow());
        assertEquals(result.getColumn(),expResult.getColumn());
    }
}
