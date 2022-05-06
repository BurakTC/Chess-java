/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;



/**
 *These colors will represent those of a player, 
 * square or pawn in our game.
 * @author g57973
 */
public enum Color {
    WHITE, BLACK;

    
/**
 * 
 * @return the opposite color to the current color
 */
    public Color opposite() {
        return this == Color.BLACK ? Color.WHITE : Color.BLACK;
    }

}
