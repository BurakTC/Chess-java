/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g57973.chess.model;

/**
 *
 * @author Burak
 */
public enum GameState {
    /**
     * Game initialized to PLAY, continue playing
     */
    PLAY,
    
    /**
     * The opposing player is in check but MAY make at least one valid move
     */
    CHECK,
    
    /**
     * The opposing player is in check and cannot make any more legal moves, the current player wins
     */
    CHECK_MATE,
    
    /**
     * No move possible for a player, draw game
     */
    STALE_MATE;
    
}
