/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 *Represents a player and his color
 * @author g57973
 */
public class Player {
    
    /**
     * Couleur du joueur
     */
    private final Color color;

    /**
     * Constructor of a player
     * @param color 
     */
    public Player(Color color) {
        this.color = color;
    }
    
    /**
     * 
     * @return a player's color
     */
    public Color getColor(){
        return this.color;
    }
    
    
    
}
